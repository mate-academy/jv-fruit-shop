package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParser {
    private static final String TITLE_STRING = "type,fruit,quantity";

    public List<FruitTransaction> parseTransactions(List<String> data) {
        return data.stream()
        .skip(1)
        .map(str -> str.split(","))
        .map(transaction -> new FruitTransaction(transaction[0],
        transaction[1], transaction[2]))
        .collect(Collectors.toList());
    }
}
