import { useState, useEffect } from "react";

import './App.css';

import BookingsForm from "./BookingsForm";
import BookingsGrid from "./BookingsGrid";
import { postBooking, getBooking, deleteBooking } from "./BookingsService";

function App() {

  const [guestBookings, setGuestBookings] = useState([]);

  useEffect(() => {
    getBooking().then((allBookings) => {
      setGuestBookings(allBookings);
    })
  }, []);

  const addBooking = (booking) => {
    setGuestBookings([...guestBookings, booking]);
  }

  const removeBooking = (id) => {
    deleteBooking(id).then(() => {
      const bookingsToKeep = guestBookings.filter(booking => booking._id !== id);
      setGuestBookings(bookingsToKeep);
    });
  }

  return (
    <>
      <BookingsForm addBooking={addBooking} />
      <BookingsGrid bookings={guestBookings} removeBooking={removeBooking} />
    </>
  );
}

export default App;
