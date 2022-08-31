package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ParsingService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.ParsingServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;
import core.basesyntax.strategy.TransactionHandlerStrategy;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/input.csv";
        final String outputFile = "src/main/resources/report.csv";
        ReaderService readerService = new ReaderServiceImpl();
        // Read date from file
        List<String> listFromFile = readerService.readFromFile(inputFile);
        ValidatorService validatorService = new ValidatorServiceImpl();
        ParsingService parsingService = new ParsingServiceImpl();
        // Validate strings
        if (validatorService.validateData(listFromFile)) {
            // Create transaction
            List<FruitTransaction> transactions = parsingService.createTransactions(listFromFile);
            TransactionHandlerStrategy strategy = new TransactionHandlerStrategy();
            TransactionService transactionService = new TransactionServiceImpl(strategy);
            // Fill in DB
            transactionService.executeTransactions(transactions);
        }
        FruitStorageDao dao = new FruitStorageDaoImpl();
        //Get data from database
        Set<Map.Entry<String, Integer>> data = dao.getEntries();
        //Create report
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(data);
        //Write report to file
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(report, outputFile);
    }
}
