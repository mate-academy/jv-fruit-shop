package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CsvTransactionsParser;
import java.util.List;
import java.util.stream.Collectors;

public class CsvTransactionsParserImpl implements CsvTransactionsParser {
    private final int operationPosition = 0;
    private final int fruitPosition = 1;
    private final int quantityPosition = 2;
    private final int titlePosition = 1;
    private final String dataSeparator = ",";

    @Override
    public List<FruitTransaction> parseTransactions(List<String> transactions) {
        return transactions.stream()
                .skip(titlePosition)
                .map(this::parseLine)
                .collect(Collectors.toList());
    }

    private FruitTransaction parseLine(String line) {
        String[] data = line.split(dataSeparator);
        return new FruitTransaction(
                FruitTransaction.Operation.getByCharacter(data[operationPosition]),
                data[fruitPosition],
                Integer.parseInt(data[quantityPosition]));
    }
}
