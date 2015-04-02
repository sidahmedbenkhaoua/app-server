package sbenkhaoua.appa.tools; /**
 * Created by sbenkhaoua on 22/03/15.
 */

import com.datastax.driver.core.*;
import sbenkhaoua.app.modules.car.model.Car;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author Venkata Ramu Kandulapati
 *         Created on Dec 23, 2014 4:59:07 PM
 */
public class CassandraConnection {

    public static Session session = null;
    public static final String KEYSPACE = "roadtraffic";
    public static final String TABLE_USERS_DATA = "car";

    public static PreparedStatement insertPstmt = null;
    public static PreparedStatement selectStmt = null;
    public static PreparedStatement deleteStmt = null;
    public static PreparedStatement updateStmt = null;

    public static final String USER_DATA_INSERT_STMT = "INSERT INTO " + KEYSPACE + "." + TABLE_USERS_DATA + "(id,carId,dateToSend,posX,posY,dateToSave)values(?,?,?,?,?,?)";


    public CassandraConnection() {
        String serverIp = "127.0.0.1";
        Cluster cluster = Cluster.builder()
                .addContactPoints(serverIp)
                .build();
        session = cluster.connect(KEYSPACE);

        insertPstmt = session.prepare(USER_DATA_INSERT_STMT);

    }


    public void insert(Car car) {
        String dateToSave = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        session.execute(insertPstmt.bind(PKeyGenerator.get(), car.getId(), car.getDateToRecive(), car.getPosX(), car.getPosY(),dateToSave));
           }

    public void retriveValues() {
        try {
            ResultSet rs = session.execute(selectStmt.bind());
            if (rs != null) {
                List<Row> rows = rs.all();
                if (rows != null) {
                    for (Row row : rows) {
                        System.out.println(row);
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Exception in select Stament" + e.getMessage());
        }
    }

    public void deleteValues() throws Exception {
        try {
            session.execute(deleteStmt.bind("Ramu"));
        } catch (Exception e) {
            throw e;
        }
    }

    public void updateValues() throws Exception {
        try {
            session.execute(updateStmt.bind(18L, "Ramu"));
        } catch (Exception e) {
            throw e;
        }
    }


}