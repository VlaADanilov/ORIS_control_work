package repository;

import mapper.GiftMapper;
import model.Gift;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class GiftRepository {

    private GiftMapper giftMapper = new GiftMapper();

    //language=sql
    private static final String GET_ALL_GIFTS = "SELECT * FROM gift";
    public List<Gift> getAll(Connection conn){
        try(PreparedStatement ps = conn.prepareStatement(GET_ALL_GIFTS)){
            ResultSet rs = ps.executeQuery();
            List<Gift> gifts = new ArrayList<>();
            while(rs.next()){
                gifts.add(giftMapper.mapRow(rs).orElseThrow(() -> new RuntimeException("Gift not found")));
            }
            return gifts;
        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    //language=sql
    private final static String GET_BY_ID = "SELECT * FROM gift WHERE gift_id = ?";
    public Optional<Gift> getById(long id, Connection conn){
        try(PreparedStatement preparedStatement = conn.prepareStatement(GET_BY_ID)){
            preparedStatement.setLong(1, id);
            ResultSet rs = preparedStatement.executeQuery();
            if(rs.next()){
                return giftMapper.mapRow(rs);
            }
            return Optional.empty();
        }catch (Exception e){
            return Optional.empty();
        }
    }
}
