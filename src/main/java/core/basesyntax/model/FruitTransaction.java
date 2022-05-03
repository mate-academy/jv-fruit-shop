package core.basesyntax.model;

public class FruitTransaction {
    private String typeOfTransaction;
    private Fruit fruit;
    private int transactionFruitQuantity;

    public FruitTransaction() {
        this.typeOfTransaction = typeOfTransaction;
        this.fruit = fruit;
        this.transactionFruitQuantity = transactionFruitQuantity;
    }

    public FruitTransaction(String typeOfTransaction, Fruit fruit,
                            Integer transactionFruitQuantity) {
        this.typeOfTransaction = typeOfTransaction;
        this.fruit = fruit;
        this.transactionFruitQuantity = transactionFruitQuantity;
    }

    public String getTypeOfTransaction() {
        return typeOfTransaction;
    }

    public void setTypeOfTransaction(String typeOfTransaction) {
        this.typeOfTransaction = typeOfTransaction;
    }

    public Fruit getTransactionFruitName() {
        return fruit;
    }

    public void setTransactionFruitName(Fruit fruit) {
        this.fruit = fruit;
    }

    public int getTransactionFruitQuantity() {
        return transactionFruitQuantity;
    }

    public void setTransactionFruitQuantity(int transactionFruitQuantity) {
        this.transactionFruitQuantity = transactionFruitQuantity;
    }
}
