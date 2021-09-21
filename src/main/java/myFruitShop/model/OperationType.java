package myFruitShop.model;

public enum OperationType {
    BALANCE("b"),
    SUPPLY("s"),
    PURCHASE("p"),
    RETURN("r");

    String shortName;
    OperationType(String shortName) {
        this.shortName = shortName;
    }
}
