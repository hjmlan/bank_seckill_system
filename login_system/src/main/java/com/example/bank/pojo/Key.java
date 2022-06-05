package com.example.bank.pojo;

public enum Key {
    firstKey("firstKey"),
    verifyKey("verifyKey");
    private String key;

    private Key(String key) {
        this.key = key;
    }
    public String getKey() {
        return key;
    }

}
