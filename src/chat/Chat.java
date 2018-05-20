package chat;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.websocket.EncodeException;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import objects.DecoderMessage;
import objects.EncoderMessage;
import objects.Message;

@ServerEndpoint(value = "/chat", encoders = { EncoderMessage.class }, decoders = { DecoderMessage.class })
public class Chat {

	private static final List<Session> conected = new ArrayList<>();

	@OnOpen
	public void init(Session session) {
		conected.add(session);
	}

	@OnClose
	public void close(Session session) {
		conected.remove(session);
	}

	@OnMessage
	public void messageHandler(Message message) throws IOException, EncodeException {
		for (Session session : conected) {
			session.getBasicRemote().sendObject(message);

		}
	}

}
