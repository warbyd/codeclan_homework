use hotel;
db.dropDatabase();

db.bookings.insertMany([
  {
    name: "Gregorio",
    email: "greg@gmail.com",
    checkedInStatus: "true"
  },
  {
    name: "Jasper",
    email: "jasper@gmail.com",
    checkedInStatus: "false"
  },
  {
    name: "Dale",
    email: "dale@gmail.com",
    checkedInStatus: "true"
  }
]);