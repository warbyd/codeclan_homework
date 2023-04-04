const Park = function (name, ticketprice) {
    this.name = name;
    this.ticketprice = ticketprice;
    this.dinosaurs = [];
  };
  
  Park.prototype.addDinosaur = function(dinosaur) {
    this.dinosaurs.push(dinosaur);
  };
  
  Park.prototype.howManyDinos = function() {
    return this.dinosaurs.length;
  };
  
  Park.prototype.removeDinosaur = function(dinosaur) {
    this.dinosaurs.pop(dinosaur);
  };
  
  Park.prototype.getDinoVisits = function() {
    let totalVisits = 0;
    for (let i = 0; i < this.dinosaurs.length; i++) {
      const dino = this.dinosaurs[i];
      totalVisits += dino.guestsAttractedPerDay;
    }
    return totalVisits;
  };
  
  Park.prototype.getMostPopularDino = function() {
    let mostPopularDino = null;
    let maxGuests = 0;
    
    for (let i = 0; i < this.dinosaurs.length; i++) {
      const dino = this.dinosaurs[i];
      if (dino.guestsAttractedPerDay > maxGuests) {
        maxGuests = dino.guestsAttractedPerDay;
        mostPopularDino = dino;
      }
    }
    
    return mostPopularDino;
  };
  
  Park.prototype.findDinosBySpecies = function(species) {
    const matchingDinos = [];
  
    for (let i = 0; i < this.dinosaurs.length; i++) {
      const dino = this.dinosaurs[i];
      if (dino.species === species) {
        matchingDinos.push(dino);
      }
    }
  
    return matchingDinos;
  };
  
  Park.prototype.getVisitorsPerDay = function() {
    let totalVisits = 0;
  
    for (let i = 0; i < this.dinosaurs.length; i++) {
      const dino = this.dinosaurs[i];
      totalVisits += dino.guestsAttractedPerDay;
    }
  
    return totalVisits;
  };
  
  Park.prototype.getVisitorsPerYear = function() {
    return this.getVisitorsPerDay() * 365;
  };
  
  Park.prototype.getYearlyRevenue = function() {
    return this.getVisitorsPerYear() * this.ticketprice;
  };
  
 

module.exports = Park;