package db;

public class ServiceReturner {
    private DataBaseConfig config;

    public ServiceReturner() {
        config = new DataBaseConfig();
    }

    public void close(){
        config.close();
    }
}