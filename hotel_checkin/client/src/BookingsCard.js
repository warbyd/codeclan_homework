import { useState } from "react";
import { updateBooking } from "./BookingsService";

const BookingCard = ({ booking, removeBooking }) => {
  const [checkedInStatus, setCheckedInStatus] = useState(booking.checkedInStatus);

  const handleCheckedInStatusChange = () => {
    const newCheckedInStatus = !checkedInStatus;
    setCheckedInStatus(newCheckedInStatus);

//     const updatedBooking = { ...booking, checkedInStatus: newCheckedInStatus };
//     updateBooking(booking._id, updatedBooking).then(() => {
//     // Optionally, you can do something after the update has completed
// });

    
  }

  return (
    <>
      <h1>{booking.name}</h1>
      <p>Email: {booking.email}</p>
      <div>
        <label>Checked In:</label>
        <span>{checkedInStatus ? "Yes" : "No"}</span>
        <button onClick={handleCheckedInStatusChange}>Update Status</button>
      </div>
      <button onClick={() => removeBooking(booking._id)}>🗑</button>
      <hr />
    </>
  );
};

export default BookingCard;
