package core.basesyntax.transaction;

import core.basesyntax.transaction.handler.BalanceOperationHandler;
import core.basesyntax.transaction.handler.OperationHandler;
import core.basesyntax.transaction.handler.PurchaseOperationHandler;
import core.basesyntax.transaction.handler.ReturnOperationHandler;
import core.basesyntax.transaction.handler.SupplyOperationHandler;
import java.util.Map;

//TODO: Зробити FruitTransaction чистим POJO (без execute()/strategy/tx)
// — прибрати залежності від handler/transaction.
//TODO: Інжектити Operation через fromCode при парсингу, але не виконувати логіку в моделі.
public class FruitTransaction {
    private Map<Operation, OperationHandler> strategy = Map.of(
            Operation.BALANCE, new BalanceOperationHandler(),
            Operation.SUPPLY, new SupplyOperationHandler(),
            Operation.PURCHASE, new PurchaseOperationHandler(),
            Operation.RETURN, new ReturnOperationHandler()
    );
    private Transaction tx = new ShopTransaction();

    private Operation operation;
    private String fruit;
    private int quantity;

    public FruitTransaction(String code, String fruit, int quantity) {
        this.operation = Operation.fromCode(code);
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public void execute() {
        OperationHandler handler = strategy.get(operation);
        handler.handle(this, tx);
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

    //TODO: Зберегти лише код і public static Operation fromCode(String code)
    // з trim() та ignoreCase;
    // кидати IllegalArgumentException для null/unknown.
    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String code;
        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }

        public static Operation fromCode(String code) {
            if (code == null) {
                throw new IllegalArgumentException("Operation code is null");
            }
            for (Operation op : Operation.values()) {
                if (op.getCode().equalsIgnoreCase(code.trim())) {
                    return op;
                }
            }
            throw new IllegalArgumentException("Unknown operation code: " + code);
        }
    }
}
