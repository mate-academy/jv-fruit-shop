package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ProcessorService;
import core.basesyntax.strategy.TransactionStrategy;
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
        rawData.stream()
                .skip(1)
                .map(n -> n.split(SEPARATOR))
                .forEach(n -> dao.update(n[FRUIT_INDEX], transactionStrategy.get(n[TYPE_INDEX])
                            .getAmount(dao.get(n[FRUIT_INDEX]),
                                    Integer.parseInt(n[QUANTITY_INDEX]))));
    }
}
