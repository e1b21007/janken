CREATE TABLE users (
    id IDENTITY,
    username VARCHAR NOT NULL
);

CREATE TABLE matches(
    id IDENTITY,
    user1 NUMBER NOT NULL,
    user2 NUMBER NOT NULL,
    user1Hand VARCHAR NOT NULL,
    user2Hand VARCHAR NOT NULL
);
