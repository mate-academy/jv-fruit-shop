package core.basesyntax.FruitShopService;

import core.basesyntax.model.FruitTransaction;

public class TransactionParser {

    public static FruitTransaction parseTransaction(String data) {
        // operation, fruitName, qnt
        String operation = data.split(",")[0];
        String fruitName = data.split(",")[1];
        int qnt = Integer.parseInt(data.split(",")[2]);
        return new FruitTransaction(operation, fruitName, qnt);
    }
}
