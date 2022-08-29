package core.basesyntax;

import core.basesyntax.dao.FruitStorageDao;
import core.basesyntax.dao.impl.FruitStorageDaoImpl;
import java.util.List;
import java.util.Map;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.ValidatorService;
import core.basesyntax.service.WriterService;
import core.basesyntax.service.impl.FruitTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ValidatorServiceImpl;
import core.basesyntax.service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/input.csv";
        final String firstReport = "src/main/resources/report.csv";
        //Read date from file
        ReaderService readerService = new ReaderServiceImpl();
        List<String> listFromFile = readerService.readFromFile(inputFile);
        //Validate strings and fill in a database
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        ValidatorService validatorService = new ValidatorServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        if (validatorService.validateData(listFromFile)) {
            for (String oneLine : listFromFile) {
                FruitTransaction transaction = fruitTransactionService
                        .processTransactionFromLine(oneLine);
                fruitStorageDao.addTransaction(transaction);
            }
        }
        //Get data from database
        Map<String, Integer> data = fruitStorageDao.getData();
        //Create report
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.createReport(data);
        //Write report to file
        WriterService writerService = new WriterServiceImpl();
        writerService.writeReport(report, firstReport);
    }
}
