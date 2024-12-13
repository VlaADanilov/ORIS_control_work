package service;

import db.DataBaseConfig;
import model.Gift;
import repository.GiftRepository;

import java.sql.Connection;
import java.util.List;

public class GiftService {
    private final GiftRepository repository = new GiftRepository();
    private final DataBaseConfig dataBaseConfig;

    public GiftService(DataBaseConfig dataBaseConfig) {
        this.dataBaseConfig = dataBaseConfig;
    }

    public List<Gift> getAllGifts() {
        try(Connection connection = dataBaseConfig.getConnection()){
            return repository.getAll(connection);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public Gift getGift(long id) {
        try(Connection connection = dataBaseConfig.getConnection()){
            return repository.getById(id, connection).orElse(null);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
