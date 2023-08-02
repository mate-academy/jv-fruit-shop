package core.basesyntax.model;

import core.basesyntax.strategy.BalanceHandler;
import core.basesyntax.strategy.FruitShopOperationsHandler;
import core.basesyntax.strategy.PurchaseHandler;
import core.basesyntax.strategy.ReturnHandler;
import core.basesyntax.strategy.SupplyHandler;
import java.util.HashMap;
import java.util.Map;

public class FruitTransaction {
    public static final Map<Operation, FruitShopOperationsHandler> PROCESS_SELECTOR
            = new HashMap<>();
    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction() {
        PROCESS_SELECTOR.put(Operation.SUPPLY, new SupplyHandler());
        PROCESS_SELECTOR.put(Operation.BALANCE, new BalanceHandler());
        PROCESS_SELECTOR.put(Operation.RETURN, new ReturnHandler());
        PROCESS_SELECTOR.put(Operation.PURCHASE, new PurchaseHandler());
    }

    public Operation getOperation() {
        return operation;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    public String getFruit() {
        return fruit;
    }

    public void setFruit(String fruit) {
        this.fruit = fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        private Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }
}
