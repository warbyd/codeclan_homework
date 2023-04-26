import { useState } from "react";
import { postBooking } from "./BookingsService";

const BookingsForm = ({ addBooking }) => {
  const [formData, setFormData] = useState({
    name: "",
    email: "",
    checkedInStatus: false,
  });

  const handleInputChange = (event) => {
    const { name, value } = event.target;
    setFormData((prevState) => ({
      ...prevState,
      [name]: value,
    }));
  };

  const toggleCheckedInStatus = () => {
    setFormData((prevState) => ({
      ...prevState,
      checkedInStatus: !prevState.checkedInStatus,
    }));
  };

  const handleSubmit = (event) => {
    event.preventDefault();
    postBooking(formData).then((data) => {
      addBooking(data);
    });
    setFormData({
      name: "",
      email: "",
      checkedInStatus: false,
    });
  };

  return (
    <form onSubmit={handleSubmit} id="bookings-form">
      <h2>Add a Guest</h2>
      <div className="formWrap">
        <label htmlFor="name">Name:</label>
        <input
          onChange={handleInputChange}
          type="text"
          id="name"
          name="name"
          value={formData.name}
        />
      </div>
      <div className="formWrap">
        <label htmlFor="email">Email:</label>
        <input
          onChange={handleInputChange}
          type="email"
          id="email"
          name="email"
          value={formData.email}
        />
      </div>
      <div className="formWrap">
        <label htmlFor="checkedInStatus">Checked In:</label>
        <span>{formData.checkedInStatus ? "Yes" : "No"}</span>
        <button type="button" onClick={toggleCheckedInStatus}>
          Update Status
        </button>
      </div>

      <input type="submit" value="Save" id="save" />
    </form>
  );
};

export default BookingsForm;
