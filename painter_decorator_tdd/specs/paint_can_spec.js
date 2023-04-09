const assert = require('assert');
const PaintCan = require('../models/paint_can.js')

describe('PaintCan', function () {
  let paintCan;

  beforeEach(() => {
    paintCan = new PaintCan(10);
  });

  it('should have a number of litres of paint', function () {
    const actual = paintCan.litres; 
    assert.strictEqual(actual, 10);
  });

  it('should be able to check if it is empty', function() {
    const actual1 = paintCan.isEmpty();
    assert.strictEqual(actual1, false);
  });

  it('should be able to add paint', function() {
    paintCan.addPaint(5);
    const actual = paintCan.isEmpty();
    assert.strictEqual(actual, false);
  });

  it('should be able to empty itself of paint', function() {
    paintCan.addPaint(5);
    paintCan.emptyPaint();
    const actual = paintCan.litres;
    assert.strictEqual(actual, 0);
  });
});
