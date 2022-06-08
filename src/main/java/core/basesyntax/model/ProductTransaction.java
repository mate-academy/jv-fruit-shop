package core.basesyntax.model;

import core.basesyntax.exception.ActionNegativeQuantityException;
import core.basesyntax.exception.OperationNotFoundException;
import java.util.Arrays;

public class ProductTransaction {
    private final Operation operation;
    private final String product;
    private final int quantity;

    public ProductTransaction(Operation operation, String product, int quantity) {
        this.operation = operation;
        this.product = product;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public static ProductTransaction of(String operation, String product, String quantity) {
        Operation operationOperation = Operation.convertStringToOperation(operation);
        int quantityInteger = Integer.parseInt(quantity);
        if (quantityInteger < 0) {
            throw new ActionNegativeQuantityException(
                    String.format("There's negative value of quantity '%d' of product '%s'",
                            quantityInteger, product));
        }
        return new ProductTransaction(operationOperation, product, quantityInteger);
    }

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private final String operation;

        Operation(String operation) {
            this.operation = operation;
        }

        public String getOperation() {
            return operation;
        }

        private static Operation convertStringToOperation(String operation) {
            return Arrays.stream(Operation.values())
                    .filter(o -> o.getOperation().equalsIgnoreCase(operation))
                    .findFirst()
                    .orElseThrow(() ->
                            new OperationNotFoundException(
                                    String.format("Error convert input string '%s' into operation",
                                            operation)));
        }
    }
}
