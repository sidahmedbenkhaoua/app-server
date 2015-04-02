package sbenkhaoua.app.modules.car.controller;

import sbenkhaoua.app.modules.car.model.Car;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.EncodeException;
import javax.websocket.Encoder;
import javax.websocket.EndpointConfig;

/**
 * Created by sbenkhaoua on 29/03/15.
 */
public class CareEncoder implements Encoder.Text<Car> {
    @Override
    public String encode(Car careDTO) throws EncodeException {
        JsonObject jsonObject = Json.createObjectBuilder()
                .add("id", careDTO.getId())
                .add("posX", careDTO.getPosX()).add("posY", careDTO.getPosY()).
                        add("dateToSend", careDTO.getDateToRecive()).build();
        return jsonObject.toString();
    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("MessageEncoder - init method called");
    }

    @Override
    public void destroy() {
        System.out.println("MessageEncoder - destroy method called");
    }
}
