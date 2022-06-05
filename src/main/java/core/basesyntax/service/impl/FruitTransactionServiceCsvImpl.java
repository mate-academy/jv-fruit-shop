package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.dao.FruitTransactionDaoCsvImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.SplitService;
import java.util.List;

public class FruitTransactionServiceCsvImpl implements FruitTransactionService {
    private FruitTransactionDao fruitTransactionDao;
    private ReaderService readerService;
    private SplitService splitService;

    public FruitTransactionServiceCsvImpl() {
        this.fruitTransactionDao = new FruitTransactionDaoCsvImpl();
        this.readerService = new ReaderServiceCsvImpl();
        this.splitService = new SplitServiceCsvImpl();
    }

    @Override
    public void addTransaction(String data) {
        List<String> dataFromCsv = readerService.readFromFile(data);
        for (String row : dataFromCsv) {
            fruitTransactionDao.add(splitService.getTransactionFromRow(row));
        }
    }

    @Override
    public List<FruitTransaction> getTransactionList() {
        return fruitTransactionDao.get();
    }
}
