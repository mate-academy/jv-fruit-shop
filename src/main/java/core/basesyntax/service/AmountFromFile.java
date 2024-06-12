package core.basesyntax.service;

import java.util.List;

public interface AmountFromFile {
    List<Integer> getAmountInShop(List<String> fruits, List<FruitTransaction> fruitTransactions);
}
