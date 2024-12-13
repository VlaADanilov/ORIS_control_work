CREATE TABLE gift(
                     gift_id BIGSERIAL PRIMARY KEY,
                     gift_name VARCHAR(250),
                     gift_donator VARCHAR(100),
                     gift_recipient VARCHAR(100),
                     date DATE
);