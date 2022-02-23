package com.bookIt.login;

public enum LoginType {

    USERNAMEPASSWORD,
    EMAILPASSWORD;

    public static LoginType getLoginTypeByKey(String key){
        return LoginType.valueOf(key.toUpperCase());
    }
}
