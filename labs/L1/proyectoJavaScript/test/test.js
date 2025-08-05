
const chai = require('chai');
const expect = chai.expect;
const greet = require('../src/greeting');
const sayGoodbye = require('../src/farewell');

describe('Greeting', function() {
    it('should say hello to Alvaro', function() {
        expect(greet('Alvaro')).to.equal('Hola, Alvaro!');
    });
});

describe('Farewell', function() {
    it('should say goodbye to Alvaro', function() {
        expect(sayGoodbye('Alvaro')).to.equal('Adiós, Alvaro!');
    });
});
