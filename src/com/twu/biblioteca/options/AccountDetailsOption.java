package com.twu.biblioteca.options;

import com.twu.biblioteca.UserAccount;

public class AccountDetailsOption implements Option{

    private UserAccount userAccount;

    public AccountDetailsOption(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    @Override
    public void onSelect() {
        System.out.println(userAccount);
    }

    @Override
    public String toString() {
        return "Check your account details";
    }
}
