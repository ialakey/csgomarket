-- begin CSGOMARKET_ITEM
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
    VOLUME varchar(255),
    --
    primary key (ID)
)^
-- end CSGOMARKET_ITEM
-- begin CSGOMARKET_USER_EMPLOYEE
create table CSGOMARKET_USER_EMPLOYEE (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    USER_ID uuid,
    TRADE_URL varchar(100),
    BALANCE decimal(20, 2),
    --
    primary key (ID)
)^
-- end CSGOMARKET_USER_EMPLOYEE
