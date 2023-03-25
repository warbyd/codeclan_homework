# events_controller.py


from flask import Flask, render_template, request, redirect, Blueprint
from models.event import Event
import repositories.event_repository as event_repository

events_blueprint = Blueprint("events", __name__)

# INDEX
# GET '/events'
@events_blueprint.route("/events")
def events():
    events = event_repository.select_all()
    return render_template("events/index.html", events=events)

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



