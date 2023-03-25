from flask import Flask, render_template, request, redirect
from flask import Blueprint
from models.task import Task
import repositories.tasks_repository as task_repository
import repositories.event_repository as event_repository

tasks_blueprint = Blueprint("tasks", __name__)

# INDEX
# GET '/tasks'
@tasks_blueprint.route("/tasks")
def tasks():
    tasks = task_repository.select_all()
    return render_template("tasks/index.html", tasks=tasks)


@tasks_blueprint.route('/tasks/new')
def new_task():
    events = event_repository.select_all()  # fetch all events
    return render_template('tasks/new.html', events=events)




@tasks_blueprint.route("/tasks", methods=['POST'])
def create_task():
    description = request.form['description']
    event_id = request.form['event']
    task = Task(description, False, event_id)
    task_repository.save(task)
    return redirect('/tasks')


# DELETE
# DELETE '/tasks/<id>'
@tasks_blueprint.route("/tasks/<id>/delete", methods=['POST'])
def delete_task(id):
    task_repository.delete(id)
    return redirect('/tasks')

# UPDATE
# POST '/tasks/<id>/update'
@tasks_blueprint.route("/tasks/<id>/update", methods=['POST'])
def update_task(id):
    task = task_repository.select(id)
    if task:
        if task.completed:
            task.completed = False
        else:
            task.completed = True
        task_repository.update(task)
    return redirect('/tasks')



