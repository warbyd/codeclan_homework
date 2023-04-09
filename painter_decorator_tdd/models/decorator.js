const Decorator = function() {
    this.paintstock = []
}


Decorator.prototype.calculateTotalLitres = function() {
    return this.paintstock.reduce((total, paintCan) => total + paintCan.litres, 0);
}

Decorator.prototype.addPaint = function() {
    return this.paintstock.push('can of paint')
}

Decorator.prototype.hasEnoughPaint = function(room) {
    const totalLitres = this.calculateTotalLitres();
    const litresPerSquareMeter = 1; 
  
    const requiredLitres = room.area * litresPerSquareMeter;
    
    return totalLitres >= requiredLitres;
  };
  

module.exports = Decorator