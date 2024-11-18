package core.basesyntax.model;

import java.util.ArrayList;
import java.util.List;

public class FruitTransactionParser {
    //idk how to write code in another way without
    // creating objects of Fruit which are apple and banana
    //I need your help here, I changed everything except of this
    private Fruit banana = new Fruit();
    private Fruit apple = new Fruit();
    private Fruit fruit;

    public Fruit getBanana() {
        return banana;
    }

    public Fruit getApple() {
        return apple;
    }

    public List<FruitTransaction> parseTransaction(String[] transactions) {
        List<FruitTransaction> fruitTransactions = new ArrayList<>();

        for (int i = 1; i < transactions.length; i++) {
            String transaction = transactions[i];
            String[] parts = transaction.split(",");

            Operation operation = Operation.getOperation(parts[0]);
            if (parts[1].startsWith("b")) {
                fruit = banana;
            } else {
                fruit = apple;
            }
            int quantity = Integer.parseInt(parts[2]);

            FruitTransaction fruitTransaction = new FruitTransaction(operation, fruit, quantity);

            fruitTransactions.add(fruitTransaction);
        }
        return fruitTransactions;
    }
}
