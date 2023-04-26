const baseURL = 'http://localhost:9000/api/bookings/'

export const getBooking = () => {
    return fetch(baseURL)
        .then(res => res.json())
}

export const postBooking = (payload) => {
    return fetch(baseURL, {
        method: 'POST',
        body: JSON.stringify(payload),
        headers: { 'Content-Type': 'application/json' }
    })
    .then(res => res.json())
}

export const deleteBooking = (id) => {
    return fetch(baseURL + id, {
        method: 'DELETE',
        headers: { 'Content-Type': 'application/json' }
    });
};

export const updateBooking = (id, data) => {
    return fetch(baseURL + id, {
        method: 'PUT',
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(data)
    })
    .then(response => response.json())
    .then(data => {
        console.log('Booking updated:', data);
        return data;
    })
    .catch(error => {
        console.error('Error updating booking:', error);
        throw error;
    });
};

  
  



