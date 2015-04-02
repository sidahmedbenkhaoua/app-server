package sbenkhaoua.app.modules.car.model;

import javax.json.JsonNumber;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by sbenkhaoua on 31/03/15.
 */
public class Car  implements Serializable{

    private String id;
    private String posX;
    private String posY;
    private String dateToSend;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPosX() {
        return posX;
    }

    public void setPosX(String posX) {
        this.posX = posX;
    }

    public String getPosY() {
        return posY;
    }

    public void setPosY(String posY) {
        this.posY = posY;
    }

    public String getDateToRecive() {
        return dateToSend;
    }

    public void setDateToRecive(String dateToSend) {
        this.dateToSend = dateToSend;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id='" + id + '\'' +
                ", posX='" + posX + '\'' +
                ", posY='" + posY + '\'' +
                ", dateToSend='" + dateToSend + '\'' +
                '}';
    }
}
