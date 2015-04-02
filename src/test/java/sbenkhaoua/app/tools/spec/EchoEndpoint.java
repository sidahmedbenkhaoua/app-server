package sbenkhaoua.app.tools.spec;

import sbenkhaoua.app.modules.car.controller.CareDecoder;
import sbenkhaoua.app.modules.car.controller.CareEncoder;
import sbenkhaoua.app.modules.car.model.Car;
import sbenkhaoua.appa.tools.CassandraConnection;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * Created by sbenkhaoua on 31/03/15.
 */
@ServerEndpoint(value = "/echo", encoders = {CareEncoder.class}, decoders = {CareDecoder.class})
public class EchoEndpoint {
    private CassandraConnection cassandraConnection ;



    @OnOpen
    public void onOpen(Session session, EndpointConfig config) throws IOException {
        cassandraConnection =new CassandraConnection();
        System.out.println("onOpen: " + session);
    }

    @OnClose
    public void onClose(Session session, CloseReason reason) throws IOException {
        System.out.println("onClose: " + session + ", " + reason);
    }

    @OnMessage
    public void onMessage(Car car, Session session) {
        cassandraConnection.insert(car);
       //System.out.println("onMessage: " + ", " + car);

    }

    @OnError
    public void onError(Session session, Throwable t) {
        System.out.println("onError: " + session + ", " + t);
    }
    public CassandraConnection getCassandraConnection() {
        return cassandraConnection;
    }

    public void setCassandraConnection(CassandraConnection cassandraConnection) {
        this.cassandraConnection = cassandraConnection;
    }

}