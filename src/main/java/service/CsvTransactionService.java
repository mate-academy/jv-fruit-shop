package service;

import dao.TransactionsDao;
import java.util.List;
import model.FruitTransaction;

public class CsvTransactionService implements Processor {
    private static final String INPUT_FILE_NAME = "inputFile";

    private final TransactionsDao transactionsDao;
    private final CsvReadService csvReadService;
    private final CsvParseService csvParserService;

    public CsvTransactionService(TransactionsDao transactionsDao, CsvReadService readService, CsvParseService csvParserService) {
        this.transactionsDao = transactionsDao;
        this.csvReadService = readService;
        this.csvParserService = csvParserService;
    }

    @Override
    public void processCsv() {
        List<String> lines
                = csvReadService.readTransactionsFromCsv(INPUT_FILE_NAME);
        List<FruitTransaction> transactions
                = lines.stream().map(csvParserService::parseTransaction).toList();
        transactions.forEach(transactionsDao::processTransaction);
    }
}
