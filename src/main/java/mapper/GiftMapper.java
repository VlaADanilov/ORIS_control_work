package mapper;

import model.Gift;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;

public class GiftMapper {
    public Optional<Gift> mapRow(ResultSet rs){
        try{
            Gift gift = new Gift();
            gift.setGift_id(rs.getLong("gift_id"));
            gift.setGift_name(rs.getString("gift_name"));
            gift.setGift_donator(rs.getString("gift_donator"));
            gift.setGift_recipient(rs.getString("gift_recipient"));
            gift.setDate(rs.getDate("date"));
            return Optional.of(gift);
        }catch (Exception e){
            e.printStackTrace();
            return Optional.empty();
        }
    }
}
