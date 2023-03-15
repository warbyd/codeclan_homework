from flask import render_template
from app import app
from models.orders_list import orders

@app.route('/orders')
def index():
    return render_template('index.html', order_list=orders)