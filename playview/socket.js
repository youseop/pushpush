import Game from './src/Game'

var webSocket;

	function connectSocket() {
		webSocket = new WebSocket('ws://' + location.host + '/location');
		webSocket.onmessage = (data => {
            var positionX = Game.this.ball1.x;
            var positionY = Game.this.ball1.y; 
		});

        //$("<input placeholder="+data.data+">"+"</input>").prependTo('#chatBox');
		//$('#chatConnect').hide();
		//$('#chat').show();
	}

	function sendMessage() {
		//webSocket.send($("#message").val());
		//$('#message').val("");
        var position = String(positionX) + '' + String(positionY);
        webSocket.send(position);

	}
