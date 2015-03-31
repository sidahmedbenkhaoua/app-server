# app-server
***java web  socket***
this is simple applicatio java implimentation api tyrus based in glassfish
to deploye application :
1-meven 2 or 3 
2-maven install 
open project in your ide eclipse or netbeanse or intelig ide and run class ***sbenkhaoua.app.tools.spec.SampleStandalone***
and try to write a simple page html to connect to this socket 
***index.html***


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>WebSocket Client</title>

    <script type="text/javascript">
        var webSocket_;

        var wsOpen = function() {
            webSocket_ = new WebSocket('ws://localhost:8025/websockets/echo');
            webSocket_.onmessage = function(e) {
                dump(e);
                var msg = document.getElementById('msg');
                msg.innerHTML = e.data + '<br/>' + msg.innerHTML;
            };
        };

        var wsClose = function() {
            if (webSocket_) {
                webSocket_.close(1000, 'Closed by user.');
                webSocket_ = null;
            }
        };

        var wsSend = function(t) {
            if (webSocket_) {
                console.log('send message : ' + t.value);
                webSocket_.send(t.value);
            }
        };
    </script>

</head>
<body >
<input id="open" type="button" value="open" onclick="wsOpen()"/>
<input id="close" type="button" value="close" onclick="wsClose()"/>
<br/>
<input id="text" type="text" onchange="wsSend(this)"/>
<div id="msg"></div>
</body>
</html>
