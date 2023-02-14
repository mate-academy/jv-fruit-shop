package com.fruitshop.servicesimpl;

public enum ShopOperations {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");
    private String operator;

    ShopOperations(String operator) {
        this.operator = operator;
    }

    public String getOperator() {
        return operator;
    }
}
