package model;

import java.sql.Date;

public class Gift {
    private long gift_id;
    private String gift_name;
    private String gift_donator;
    private String gift_recipient;
    private Date date;


    public Gift() {
    }

    public Gift(long gift_id, String gift_name, String gift_donator, String gift_recipient, Date date) {
        this.gift_id = gift_id;
        this.gift_name = gift_name;
        this.gift_donator = gift_donator;
        this.gift_recipient = gift_recipient;
        this.date = date;
    }

    public long getGift_id() {
        return gift_id;
    }

    public void setGift_id(long gift_id) {
        this.gift_id = gift_id;
    }

    public String getGift_name() {
        return gift_name;
    }

    public void setGift_name(String gift_name) {
        this.gift_name = gift_name;
    }

    public String getGift_donator() {
        return gift_donator;
    }

    public void setGift_donator(String gift_donator) {
        this.gift_donator = gift_donator;
    }

    public String getGift_recipient() {
        return gift_recipient;
    }

    public void setGift_recipient(String gift_recipient) {
        this.gift_recipient = gift_recipient;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
