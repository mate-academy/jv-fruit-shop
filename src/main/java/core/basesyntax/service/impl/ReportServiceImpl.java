package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriterService;
import core.basesyntax.strategy.TransactionStrategy;

public class ReportServiceImpl implements ReportService {
    private final TransactionStrategy transactionStrategy;
    private final WriterService writerService;

    public ReportServiceImpl(TransactionStrategy transactionStrategy, WriterService writerService) {
        this.transactionStrategy = transactionStrategy;
        this.writerService = writerService;
    }

    @Override
    public void countAmountOfFruits() {
        Storage.fruitTransactions
                .forEach(transaction -> transactionStrategy
                        .get(transaction.getOperation())
                        .doTransaction(transaction.getFruit(), transaction.getQuantity()));
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity" + System.lineSeparator());
        Storage.fruits.forEach(fruit -> stringBuilder.append(fruit.toString()));
        writerService.writeInfoToFile(stringBuilder.toString());
    }
}
