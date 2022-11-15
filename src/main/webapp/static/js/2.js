const fs = require('fs');
const path = require('path');
const mineType = require('mime-types');
function imgto64(filepath) {
let filePath = path.resolve(filepath);
 
let data = fs.readFileSync(filePath);
data = new Buffer(data).toString('base64');
 
let base64 = 'data:' + mineType.lookup(filePath) + ';base64,' + data;
return base64
}
const Websocket = require('ws');
//引入serve并实例化
const wss = new Websocket.Server({port :5000})
//连接

wss.on('connection', function(ws){
    ws.on('message', function(message){
       for(var i = 1;i<190;i++ )
       {
        ws.send(imgto64('imge/coal@'+i+'.jpg'))
       }

    })
    })
