const assert = require('assert');
const Park = require('../models/park.js');
const Dinosaur = require('../models/dinosaur.js');

describe('Park', function() {

  let park, trex, stegosaurus, triceratops, velociraptor, brachiosaurus, ankylosaurus, tyrannosaurus, diplodocus, allosaurus;

  beforeEach(function () {
    park = new Park('Dale Parkland', 10, []);
    trex = new Dinosaur('T-Rex', 'Humans', 50);
    stegosaurus = new Dinosaur('Stegosaurus', 'Plants', 100);
    triceratops = new Dinosaur('Triceratops', 'Plants', 75);
    velociraptor = new Dinosaur('Velociraptor', 'Meat', 50);
    brachiosaurus = new Dinosaur('Brachiosaurus', 'Plants', 150);
    ankylosaurus = new Dinosaur('Ankylosaurus', 'Plants', 90);
    tyrannosaurus = new Dinosaur('Tyrannosaurus', 'Meat', 60);
    diplodocus = new Dinosaur('Diplodocus', 'Plants', 120);
    allosaurus = new Dinosaur('Allosaurus', 'Meat', 70);
  });

  it('should have a name', function() {
    assert.strictEqual(park.name, 'Dale Parkland');
  });

  it('should have a ticket price', function() {
    assert.strictEqual(park.ticketprice, 10);
  });

  it('should have a collection of dinosaurs', function() {
    assert.deepStrictEqual(park.dinosaurs, []);
  });

  it('should be able to add a dinosaur to its collection', function() {
    park.addDinosaur(trex);
    assert.strictEqual(park.dinosaurs.length, 1);
  });

  it('should be able to remove a dinosaur from its collection', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.removeDinosaur(stegosaurus);
    assert.strictEqual(park.dinosaurs.length, 1);
  });

  it('should be able to find the dinosaur that attracts the most visitors', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.addDinosaur(triceratops);
    park.addDinosaur(velociraptor);
    park.addDinosaur(brachiosaurus);
    park.addDinosaur(ankylosaurus);
    park.addDinosaur(tyrannosaurus);
    park.addDinosaur(diplodocus);
    park.addDinosaur(allosaurus);

    assert.deepStrictEqual(park.getMostPopularDino(), brachiosaurus);
  });

  it('should be able to find all dinosaurs of a particular species', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.addDinosaur(triceratops);
    park.addDinosaur(velociraptor);
    park.addDinosaur(brachiosaurus);
    park.addDinosaur(ankylosaurus);
    park.addDinosaur(tyrannosaurus);
    park.addDinosaur(diplodocus);
    park.addDinosaur(allosaurus);

    assert.deepStrictEqual(park.findDinosBySpecies('T-Rex'), [trex]);
  });

  it('should be able to calculate the total number of visitors per day', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.addDinosaur(triceratops);
    
    const expectedTotalVisits = trex.guestsAttractedPerDay +
                                 stegosaurus.guestsAttractedPerDay +
                                 triceratops.guestsAttractedPerDay;
                                 
    assert.strictEqual(park.getDinoVisits(), expectedTotalVisits);
  });

  it('should be able to calculate the total number of visitors per year', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.addDinosaur(triceratops);
    
    const expectedYearlyVisits = park.getDinoVisits() * 365;
    
    assert.strictEqual(park.getVisitorsPerYear(), expectedYearlyVisits);
  });

  it('should be able to calculate total revenue for one year', function() {
    park.addDinosaur(trex);
    park.addDinosaur(stegosaurus);
    park.addDinosaur(triceratops);
    
    const expectedYearlyRevenue = park.getVisitorsPerYear() * park.ticketprice;
    
    assert.strictEqual(park.getYearlyRevenue(), expectedYearlyRevenue);
  });

});
