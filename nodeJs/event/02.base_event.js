var EventEmitter = require("events");

class CustomEvent extends EventEmitter {

}

var ce = new CustomEvent();

ce.on('error',(err,time) => {
console.log(err);
console.log(time);
});


ce.emit('error',new Error('opps! '),Date.now());
