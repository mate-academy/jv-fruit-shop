package service.basesyntax.service;

import java.util.ArrayList;
import java.util.List;
import service.basesyntax.model.FruitTransaction;

public class TransactionParserService {
    private final TransactionParser transactionParser;

    public TransactionParserService(TransactionParser transactionParser) {
        if (transactionParser == null) {
            throw new NullPointerException("transactionParser is null");
        }
        this.transactionParser = transactionParser;
    }

    public List<FruitTransaction> parseTransactions(List<String> lines) {
        if (lines == null) {
            throw new NullPointerException("lines is null");
        }
        List<FruitTransaction> transactions = new ArrayList<>();

        for (String line : lines) {
            if (line.trim().isEmpty() || line.startsWith("type")) {
                continue;
            }
            transactions.add(transactionParser.parse(line));
        }
        return transactions;
    }
}
