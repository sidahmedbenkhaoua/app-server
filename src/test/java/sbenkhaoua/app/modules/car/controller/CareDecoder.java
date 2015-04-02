package sbenkhaoua.app.modules.car.controller;


import sbenkhaoua.app.modules.car.model.Car;

import javax.json.Json;
import javax.json.JsonObject;
import javax.websocket.DecodeException;
import javax.websocket.Decoder;
import javax.websocket.EndpointConfig;
import java.io.StringReader;
import java.math.BigDecimal;

/**
 * Created by sbenkhaoua on 29/03/15.
 */
public class CareDecoder implements Decoder.Text<Car> {

    @Override
    public Car decode(String s) {
        try {
            JsonObject jsonObject = Json.createReader(new StringReader(s)).readObject();
            Car careDTO = new Car();
            careDTO.setId(jsonObject.getString("id"));
            careDTO.setPosX( jsonObject.getString("posX"));
            careDTO.setPosY( jsonObject.getString("posY"));
            careDTO.setDateToRecive(jsonObject.getString("dateToSend"));
            return careDTO;

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
return  null;
    }

    @Override
    public boolean willDecode(String s) {


        return true;

    }

    @Override
    public void init(EndpointConfig endpointConfig) {
        System.out.println("int");
    }

    @Override
    public void destroy() {
        System.out.println("destroy");
    }
}
