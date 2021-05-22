var webSocket;

export function connectSocket(roomId) {
  webSocket = new WebSocket(`ws://game/chat/${roomId}`);
  webSocket.onmessage = (data => {
    // $("<p>"+data.data+"</p>").prependTo('#chatBox');
    console.log(data.data, 'socekt!!!', roomId)
  });

  // $('#chatConnect').hide();
  // $('#chat').show();
}

export function sendMessage() {
  // webSocket.send($("#message").val());
  // $('#message').val("");
  webSocket.send('hey!!')
}

