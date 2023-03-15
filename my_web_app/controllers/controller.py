from flask import render_template
from app import app
from models.orders_list import orders, get_order

@app.route('/orders')
def index():
    return render_template('index.html', order_list=orders)



@app.route('/orders/<id>')
def order(id):
    selected_order = get_order(int(id))
    return render_template('order.html', order=selected_order)