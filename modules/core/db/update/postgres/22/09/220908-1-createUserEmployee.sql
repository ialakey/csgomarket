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
);