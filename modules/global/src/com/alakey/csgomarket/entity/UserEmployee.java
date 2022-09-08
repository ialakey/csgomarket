package com.alakey.csgomarket.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.StandardEntity;
import com.haulmont.cuba.security.entity.User;

import javax.persistence.*;
import java.math.BigDecimal;

@Table(name = "CSGOMARKET_USER_EMPLOYEE")
@Entity(name = "csgomarket_UserEmployee")
@NamePattern("%s|id")
public class UserEmployee extends StandardEntity {
    private static final long serialVersionUID = -6319638219716427940L;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USER_ID")
    protected User user;

    @Column(name = "TRADE_URL" , length = 100)
    private String tradeUrl;

    @Column(name = "BALANCE", precision = 20, scale = 2)
    private BigDecimal balance;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTradeUrl() {
        return tradeUrl;
    }

    public void setTradeUrl(String tradeUrl) {
        this.tradeUrl = tradeUrl;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}