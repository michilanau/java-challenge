DROP TABLE IF EXISTS NUMBERS CASCADE;

CREATE TABLE IF NOT EXISTS  NUMBERS
(
    id       INT         NOT NULL,
    integers VARCHAR(20) NOT NULL,
    PRIMARY KEY (ID)
);

INSERT INTO NUMBERS (id, integers)
VALUES (1, '1,15,5,7,3');