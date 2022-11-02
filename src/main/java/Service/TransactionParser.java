package Service;

import core.basesyntax.FruitTransaction;

import java.util.List;

public interface TransactionParser {
    void process(List<FruitTransaction> fruitTransactions);
    List<FruitTransaction> parse(List<String> lines);

    FruitTransaction parseTransaction(String line);

}
