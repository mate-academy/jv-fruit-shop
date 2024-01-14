package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.TransactionService;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionParserImpl implements TransactionParser {
    private final TransactionService transactionService;

    public TransactionParserImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public List<FruitTransaction> parse(List<String> lines) {
        return lines.stream()
                .map(transactionService::createTransaction)
                .collect(Collectors.toList());
    }
}
