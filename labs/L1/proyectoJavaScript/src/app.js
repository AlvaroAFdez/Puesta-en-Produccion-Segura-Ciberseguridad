const Greeting = require('./greeting');
const Farewell = require('./farewell');

const greeting = new Greeting();
const farewell = new Farewell();

const name = "Alvaro"
console.log(greeting.sayHello(name));
console.log(farewell.sayGoodbye(name));