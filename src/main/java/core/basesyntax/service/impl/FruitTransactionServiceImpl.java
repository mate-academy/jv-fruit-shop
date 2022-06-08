package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.SplitService;
import java.util.List;

public class FruitTransactionServiceImpl implements FruitTransactionService {
    private static final int TABLE_NAME = 0;
    private FruitTransactionDao fruitTransactionDao;
    private ReaderService readerService;
    private SplitService splitService;

    public FruitTransactionServiceImpl(FruitTransactionDao fruitTransactionDao,
                                       ReaderService readerService, SplitService splitService) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.readerService = readerService;
        this.splitService = splitService;
    }

    @Override
    public void addTransaction(String data) {
        List<String> dataFromCsv = readerService.readFromFile(data);
        dataFromCsv.remove(TABLE_NAME);
        for (String row : dataFromCsv) {
            fruitTransactionDao.add(splitService.getTransactionFromRow(row));
        }
    }

    @Override
    public List<FruitTransaction> getTransactionList() {
        return fruitTransactionDao.get();
    }
}
