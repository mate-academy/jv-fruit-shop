package core.basesyntax.service.impl;

import core.basesyntax.FruitTransaction;
import core.basesyntax.service.converter.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    private final DataParser dataParser = new DataParser();
    private final TransactionFactory transactionFactory = new TransactionFactory();

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<String[]> parsedLines = dataParser.parseLines(data);
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String[] parts : parsedLines) {
            FruitTransaction transaction = transactionFactory.createTransaction(parts);
            transactions.add(transaction);
        }
        return transactions;
    }
}