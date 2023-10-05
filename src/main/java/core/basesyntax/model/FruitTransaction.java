package core.basesyntax.model;

import com.opencsv.bean.AbstractBeanField;
import com.opencsv.bean.CsvCustomBindByName;

public class FruitTransaction {
    private static final String COLUMN_NAME_TYPE = "type";
    private static final String COLUMN_NAME_FRUIT = "fruit";
    private static final String COLUMN_NAME_QUANTITY = "quantity";
    @CsvCustomBindByName(converter = OperationConverter.class, column = COLUMN_NAME_TYPE)
    private Operation operation;
    @CsvCustomBindByName(converter = FruitConverter.class, column = COLUMN_NAME_FRUIT)
    private Fruit fruit;
    @CsvCustomBindByName(converter = QuantityConverter.class, column = COLUMN_NAME_QUANTITY)
    private int quantity;

    public FruitTransaction() {
    }

    public FruitTransaction(final Operation operation, final Fruit fruit, final int quantity) {
        this.operation = operation;
        this.fruit = fruit;
        this.quantity = quantity;
    }

    public Operation getOperation() {
        return operation;
    }

    public Fruit getFruit() {
        return fruit;
    }

    public int getQuantity() {
        return quantity;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof FruitTransaction)) {
            return false;
        }
        final FruitTransaction transaction = (FruitTransaction) o;
        if (quantity != transaction.quantity) {
            return false;
        }
        if (operation != transaction.operation) {
            return false;
        }
        return fruit != null ? fruit.equals(transaction.fruit) : transaction.fruit == null;
    }

    @Override
    public int hashCode() {
        int result = operation != null ? operation.hashCode() : 0;
        result = 31 * result + (fruit != null ? fruit.hashCode() : 0);
        result = 31 * result + quantity;
        return result;
    }

    @Override
    public String toString() {
        return "FruitTransaction{"
                + "operation=" + operation + ", fruit=" + fruit + ", quantity=" + quantity + '}';
    }

    public static class OperationConverter extends AbstractBeanField<Operation, Integer> {
        @Override
        protected Operation convert(final String value) {
            return Operation.getOperationByCode(value);
        }
    }

    public static class FruitConverter extends AbstractBeanField<Operation, Integer> {
        @Override
        protected Fruit convert(final String value) {
            return new Fruit(value);
        }
    }

    public static class QuantityConverter extends AbstractBeanField<Operation, Integer> {
        @Override
        protected Integer convert(final String value) {
            return Integer.parseInt(value);
        }
    }
}
