package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;

public class OperationParser {
    private static final String BALANCE_CODE = "b";
    private static final String SUPPLY_CODE = "s";
    private static final String PURCHASE_CODE = "p";
    private static final String RETURN_CODE = "r";

    public FruitTransaction.Operation parseOperationFromCode(String code) {
        switch (code) {
            case BALANCE_CODE -> {
                return FruitTransaction.Operation.BALANCE;
            }
            case SUPPLY_CODE -> {
                return FruitTransaction.Operation.SUPPLY;
            }
            case PURCHASE_CODE -> {
                return FruitTransaction.Operation.PURCHASE;
            }
            case RETURN_CODE -> {
                return FruitTransaction.Operation.RETURN;
            }
            default -> throw new IllegalArgumentException("Invalid operation code: " + code);
        }
    }
}
