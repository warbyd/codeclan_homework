from models.order import *



order1 = Order(1, "Bob", "March 3rd", 2, "The Bible")
order2 = Order(2, "Steve", "March 4th", 2, "Harry Potter")
order3 = Order(3, "Alex", "March 5th", 2, "Think and Grow Rich")
orders = [order1, order2, order3]

def get_order(order_id):
    return orders[order_id-1]
    



# class Order():

#     def __init__(self, customer_name, order_date, quantity, book_title):
#         self.customer_name = customer_name
#         self.order_date = order_date
#         self.quantity = quantity
#         self.book_title = book_title
        