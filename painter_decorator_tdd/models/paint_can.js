const PaintCan = function (litres) {
    this.litres = litres
}

PaintCan.prototype.addPaint = function (litresToAdd) {
    // Check if the input is a positive number before updating litres
    if (litresToAdd > 0) {
      this.litres += litresToAdd;
    }
  };
  
  PaintCan.prototype.emptyPaint = function () {
    this.litres = 0;
  };
  
  PaintCan.prototype.isEmpty = function () {
    return this.litres === 0;
  };



module.exports = PaintCan