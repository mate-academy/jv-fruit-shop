package core.basesyntax;

import core.basesyntax.model.FruitTransaction;

public class App {
    public static void main(String[] args) {
        FruitTransaction fruitTransaction = new FruitTransaction();
        fruitTransaction.setOperation("t");
        System.out.println(fruitTransaction.getOperation());
        fruitTransaction.setOperation("b");
        System.out.println(fruitTransaction.getOperation());
        fruitTransaction.setOperation("t");
        System.out.println(fruitTransaction.getOperation());
    }
}
