package service;

import dao.TransactionsDao;
import java.util.List;
import model.FruitTransaction;

public class CsvTransactionService implements Processor {
    private static final String INPUT_FILE_NAME = "inputFile";

    private final TransactionsDao transactionsDao;
    private final CsvReadService csvReadService;

    public CsvTransactionService(TransactionsDao transactionsDao, CsvReadService readService) {
        this.transactionsDao = transactionsDao;
        this.csvReadService = readService;
    }

    @Override
    public void processCsv() {
        List<FruitTransaction> transactions
                = csvReadService.readTransactionsFromCsv(INPUT_FILE_NAME);
        transactions.forEach(transactionsDao::processTransaction);
    }
}
