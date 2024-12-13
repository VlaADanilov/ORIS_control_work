package db;

import service.GiftService;

public class ServiceReturner {
    private DataBaseConfig config;

    public ServiceReturner() {
        config = new DataBaseConfig();
    }

    public void close(){
        config.close();
    }

    public GiftService getGiftService(){
        return new GiftService(config);
    }
}
