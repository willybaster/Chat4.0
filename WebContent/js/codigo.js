(function(window, document, JSON){
	'use strict';
	
	var url = 'ws://'+window.location.host+'/Chat4.0/chat',
		ws = new WebSocket(url),
		messages = document.getElementById('conversation'),
		button = document.getElementById('btnSend'),
		name = document.getElementById('user'),
		message = document.getElementById('message');
	
	console.log('ws'+ws);
	ws.onopen = onOpen;
	ws.onclose = onClose;
	ws.onmessage = onMessage;
	
	
	button.addEventListener('click',send);
	
	function onOpen(){
		console.log('Conected...');
	}
	
	function onClose(){
		console.log('Disconnected');
	}
	
	function send(){
		console.log('send');
		console.log('user: '+user.value);
		console.log('message: '+message.value);
		var msg={
				user: name.value,
				message: message.value
		};
		
		ws.send(JSON.stringify(msg));
	}
	
	function onMessage(event){
		console.log('event' + event);
		var obj = JSON.parse(event.data),
			msg = 'Name: '+obj.user+' says: '+obj.message;
		messages.innerHTML += '<br/>' +msg;
	}
	
})(window,document,JSON);