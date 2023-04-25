const express = require('express');
const app = express();

const cors = require('cors');
app.use(cors());
app.use(express.json());

const MongoClient = require('mongodb').MongoClient;
const createRouter = require('./helpers/create_router.js');

MongoClient.connect('mongodb://127.0.0.1:27017', { useUnifiedTopology: true })
  .then((client) => {
    const db = client.db('birds');
    const sightingsCollection = db.collection('sightings');
    const sightingsRouter = createRouter(sightingsCollection);
    app.use('/api/sightings', sightingsRouter);

    app.post('/api/birds/sightings', (req, res) => {
      const sighting = req.body;
      sightingsCollection.insertOne(sighting)
        .then(result => {
          res.json(result.ops[0]);
        })
        .catch(error => {
          console.error(error);
          res.status(500).send('Error adding sighting');
        });
    });

  })
  .catch(console.err);

app.listen(9000, function () {
  console.log(`Listening on port ${ this.address().port }`);
});
