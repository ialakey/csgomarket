create table CSGOMARKET_ITEM (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    HASH_NAME varchar(255),
    SELL_PRICE_TEXT varchar(255),
    SALE_PRICE_NAME varchar(255),
    APP_NAME varchar(255),
    APP_ID varchar(255),
    ICON_URL varchar(255),
    TYPE varchar(255),
    --
    primary key (ID)
);