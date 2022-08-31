package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ExecuteTransactionService;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ExecuteTransactionServiceImpl;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ParsingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/input.csv";
        final String firstReport = "src/main/resources/report.csv";
        ReaderService readerService = new ReaderServiceImpl();
        // Read date from file
        List<String> listFromFile = readerService.readFromFile(inputFile);
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        ValidatorService validatorService = new ValidatorServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        ExecuteTransactionService executeTransactionService = new ExecuteTransactionServiceImpl();
        ParsingService parsingService = new ParsingServiceImpl();
        // Validate strings
        if (validatorService.validateData(listFromFile)) {
            // Read data from string
            List<String[]> parsedData = parsingService.parseData(listFromFile);
            // Create transactions
            List<FruitTransaction> transactions = fruitTransactionService
                    .createTransactions(parsedData);
            // Fill in DB
            executeTransactionService.executeTransactions(transactions);
        }
        //Get data from database
        Set<Map.Entry<String, Integer>> data = fruitStorageDao.getData();
        //Create report
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(data);
        //Write report to file
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(report, firstReport);
    }
}
