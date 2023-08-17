package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParserService;
import java.util.List;
import java.util.stream.Collectors;

public class ParserServiceImpl implements ParserService {
    public static final String SEPARATOR = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .map(string -> {
                    String [] split = string.split(SEPARATOR);
                    FruitTransaction.Operation operation = FruitTransaction.Operation
                            .getCode(split[0]);
                    String frutis = split[1];
                    int size = Integer.parseInt(split[2]);
                    return new FruitTransaction(operation, frutis, size);
                })
                .collect(Collectors.toList());
    }
}
