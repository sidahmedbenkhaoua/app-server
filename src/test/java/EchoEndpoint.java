import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by sbenkhaoua on 31/03/15.
 */
@ServerEndpoint(value = "/echo")
public class EchoEndpoint {

    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        System.out.println("onOpen: " + session);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException {
        System.out.println("onClose: " + session + ", " + reason);
    }

    @OnMessage
    public void onMessage(Session session, String message) {
        System.out.println("onMessage: " + session + ", " + message);
        for (Session s : session.getOpenSessions()) {
            s.getAsyncRemote().sendText(message);
        }
    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("onError: " + session + ", " + t);
    }
}