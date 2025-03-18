package com.parkinglot.domain.models.Account;

import com.parkinglot.domain.enums.AccountStatus;

public class Account {
    private String username;
    private String password;
    private Person person;
    private AccountStatus accountStatus;

    public Account(String username, String password, Person person) {
        this.username = username;
        this.password = password;
        this.person = person;
        this.accountStatus = AccountStatus.ACTIVE;
    }
}
