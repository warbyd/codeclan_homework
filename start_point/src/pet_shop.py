# WRITE YOUR FUNCTIONS HERE
def get_pet_shop_name(pet_shop):
    """
    Returns the name of the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.

    Returns:
        str: The name of the pet shop.
    """
    return pet_shop["name"]

def get_total_cash(pet_shop):
    """
    Returns the total amount of cash in the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.

    Returns:
        int: The total amount of cash in the pet shop.
    """
    return pet_shop["admin"]["total_cash"]

def add_or_remove_cash(pet_shop, amount):
    """
    Adds or removes cash from the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.
        amount (int): The amount of cash to add or remove.

    Returns:
        None
    """
    pet_shop["admin"]["total_cash"] += amount

def add_or_remove_cash(pet_shop, amount):
    """
    Adds or removes cash from the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.
        amount (int): The amount of cash to add or remove.

    Returns:
        None
    """
    pet_shop["admin"]["total_cash"] += amount

def get_pets_sold(pet_shop):
    """
    Returns the number of pets sold by the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.

    Returns:
        int: The number of pets sold.
    """
    return pet_shop["admin"]["pets_sold"]

def increase_pets_sold(pet_shop, number):
    """
    Increases the number of pets sold by the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.
        number (int): The number of pets sold to add to the total.

    Returns:
        None
    """
    pet_shop["admin"]["pets_sold"] += number

def get_stock_count(pet_shop):
    """
    Returns the number of pets that are currently in stock at the given pet shop.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.

    Returns:
        int: The number of pets in stock.
    """
    return len(pet_shop["pets"])

def get_pets_by_breed(pet_shop, breed):
    """
    Returns a list of all pets in the given pet shop that have the given breed.

    Args:
        pet_shop (dict): A dictionary representing the pet shop.
        breed (str): The breed to search for.

    Returns:
        list: A list of pets with the given breed.
    """
    pets_with_breed = []
    for pet in pet_shop["pets"]:
        if pet["breed"] == breed:
            pets_with_breed.append(pet)
    return pets_with_breed

def get_pets_by_breed(pet_shop, breed):
    pets = []
    for pet in pet_shop["pets"]:
        if pet["breed"] == breed:
            pets.append(pet)
    return pets

def find_pet_by_name(pet_shop, name):
    for pet in pet_shop["pets"]:
        if pet["name"] == name:
            return pet
    return None

def find_pet_by_name(pet_shop, name):
    for pet in pet_shop["pets"]:
        if pet["name"] == name:
            return pet
    return None

def remove_pet_by_name(pet_shop, name):
    for pet in pet_shop["pets"]:
        if pet["name"] == name:
            pet_shop["pets"].remove(pet)
            return
        
def add_pet_to_stock(pet_shop, new_pet):
    pet_shop["pets"].append(new_pet)

def get_customer_cash(customer):
    return customer["cash"]

def remove_customer_cash(customer, amount):
    customer["cash"] -= amount

def get_customer_pet_count(customer):
    return len(customer["pets"])

def add_pet_to_customer(customer, pet):
    pets = customer["pets"]
    pets.append(pet)
    customer["pets"] = pets