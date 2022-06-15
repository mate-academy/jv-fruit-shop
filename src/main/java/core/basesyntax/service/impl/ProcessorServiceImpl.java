package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.strategy.TransactionStrategy;
import core.basesyntax.strategy.transaction.FruitTransaction;
import java.util.List;

public class ProcessorServiceImpl implements ProcessorService {
    private static final String SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private TransactionStrategy transactionStrategy;
    private FruitDao dao;

    public ProcessorServiceImpl(FruitDao dao, TransactionStrategy transactionStrategy) {
        this.transactionStrategy = transactionStrategy;
        this.dao = dao;
    }

    @Override
    public void processData(List<String> rawData) {
        final String[] columnNames = rawData.get(0).split(SEPARATOR);

        rawData.stream()
                .map(n -> n.split(SEPARATOR))
                .forEach(n -> {
                    FruitTransaction transaction = new FruitTransaction(n[TYPE_INDEX],
                            n[FRUIT_INDEX], Integer.parseInt(n[QUANTITY_INDEX]));
                    int newAmount = transactionStrategy.get(transaction.getOperation())
                            .getAmount(dao.get(transaction.getFruit()), transaction.getQuantity());
                    dao.update(transaction.getFruit(), newAmount);
                });
    }
}
