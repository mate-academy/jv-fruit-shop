package core.basesyntax.strategy.activity;

public interface ActivityHandler {
    String BALANCE = "b";
    String PURCHASE = "p";
    String RETURN = "r";
    String SUPPLY = "s";

    int get(int quantity);
}
