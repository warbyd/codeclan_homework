const assert = require('assert');
const Decorator = require('../models/decorator.js');
const Room = require('../models/room.js')
const PaintCan = require('../models/paint_can.js')

describe ('Decorator', function() {
    let paintstock = []
    let decorator;
    let room;
    let paintCan1;
    let paintCan2;

    beforeEach(() => {
        decorator = new Decorator();
        room = new Room(20);
        paintCan1 = new PaintCan(30);
        paintCan2 = new PaintCan(5);
    });

    it('should start with empty paint stock', function() {
        const actual = decorator.calculateTotalLitres();
        assert.strictEqual(actual, 0)
    })
    
    it('should be able to add a can of paint to paint stock', function() {
        const actual = decorator.addPaint(paintstock);
        assert.strictEqual(actual, 1)
    })
    it('should be able to calculate total litres of paint stock', function() {
        decorator.paintstock = [
            {litres: 2},
            {litres: 3}
        ]
        const actual = decorator.calculateTotalLitres();
        assert.strictEqual(actual, 5)
    })

    it('it should be able to calculate if it has enough paint to paint a room', function() {
        decorator.addPaint(paintCan1)
        decorator.addPaint(paintCan2)
        room.area = 20
        const actual = decorator.hasEnoughPaint(room)
        assert.strictEqual(actual, false)
    })

    it('it should be able to paint a room if decorator has enough stock', function() {
        decorator.addPaint(paintCan1)
        decorator.addPaint(paintCan2)
        room.area = 20
        const hasEnoughPaint = decorator.hasEnoughPaint(room)
        assert.strictEqual(hasEnoughPaint, false)
    })

    

});