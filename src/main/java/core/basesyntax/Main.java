package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.operator.Operator;
import core.basesyntax.service.operator.OperatorImpl;

public class Main {
    public static void main(String[] args) {
        Operator operator = new OperatorImpl();
        System.out.println(operator.openShift() + " records loaded to database.");
        operator.newTransaction(new Transaction(Transaction.TransactionType.SUPPLY,
                new Fruit(Fruit.FruitType.GRAPEFRUIT),
                18));
        operator.newTransaction(new Transaction(Transaction.TransactionType.PURCHASE,
                new Fruit(Fruit.FruitType.GRAPEFRUIT),
                9));
        System.out.println(operator.closeShift() + " records unloaded from database.");
    }
}
