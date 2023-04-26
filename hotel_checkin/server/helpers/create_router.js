const express = require('express');
const { ObjectId } = require('mongodb');

const createRouter = function (collection) {

  const router = express.Router();

  router.get('/', (req, res) => {
    collection
      .find()
      .toArray()
      .then((docs) => res.json(docs))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });

  router.get('/:id', (req, res) => {
    const id = req.params.id;
    collection
      .findOne({ _id: new ObjectId(id) })
      .then((doc) => res.json(doc))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });

  router.post('/', (req, res) => {
    const newBooking = req.body;
    collection
      .insertOne(newBooking)
      .then(() => res.status(201).json(newBooking))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });

  router.delete('/:id', (req, res) => {
    const id = req.params.id;
    collection
      .deleteOne({ _id: new ObjectId(id) })
      .then(() => res.sendStatus(204))
      .catch((err) => {
        console.error(err);
        res.status(500);
        res.json({ status: 500, error: err });
      });
  });
  
  router.put('/:id', (req, res) => {
  const id = req.params.id;
  const updatedBooking = req.body;
  collection
    .updateOne(
      { _id: new ObjectId(id) },
      { $set: updatedBooking }
    )
    .then(() => res.sendStatus(204))
    .catch((err) => {
      console.error(err);
      res.status(500);
      res.json({ status: 500, error: err });
    });
});

  
  

  return router;
};

module.exports = createRouter;
