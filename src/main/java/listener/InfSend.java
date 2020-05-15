package listener;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

public class InfSend {
    private static final InfluxDB inflx = InfluxDBFactory.connect("http://172.17.0.1:8086", "root",
            "root");
    private static final String db = "selen";

    static {
        inflx.setDatabase(db);
    }
    public static void send(final Point point){
        inflx.write(point);
    }

}
