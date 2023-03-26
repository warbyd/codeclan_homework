# events_controller.py

from flask import Flask, render_template, request, redirect, Blueprint
from models.event import Event
import repositories.event_repository as event_repository
import repositories.tasks_repository as task_repository

events_blueprint = Blueprint("events", __name__)

# INDEX
# GET '/events'
@events_blueprint.route("/events")
def events():
    events = event_repository.select_all()
    tasks_for_events = {}
    for event in events:
        tasks_for_events[event.id] = task_repository.get_tasks_for_event(event.id)
    return render_template("events/index.html", events=events, tasks_for_events=tasks_for_events)


# NEW
# GET '/events/new'
@events_blueprint.route("/events/new", methods=['GET'])
def new_event():
    return render_template("events/new.html")

# CREATE
# POST '/events'
@events_blueprint.route("/events", methods=['POST'])
def create_event():
    title = request.form['title']
    location = request.form['location']
    date = request.form['date']
    start_time = request.form['start_time']
    end_time = request.form['end_time']
    description = request.form['description']
    user_id = request.form['user_id']
    event = Event(id=1, title=title, location=location, date=date, start_time=start_time, end_time=end_time, description=description, user_id=user_id)
    event_repository.save(event)
    return redirect('/events')

# DELETE
# DELETE '/events/<id>'
@events_blueprint.route("/events/<id>/delete", methods=['POST'])
def delete_event(id):
    event_repository.delete(id)
    return redirect('/events')

# GET '/events/<int:event_id>'
@events_blueprint.route('/events/<int:event_id>')
def event(event_id):
    event = event_repository.select(event_id)
    tasks = task_repository.get_tasks_for_event(event_id)
    return render_template('events/event.html', event=event, tasks=tasks)




