package core.basesyntax;

import dao.StorageDao;
import dao.impl.StorageDaoImpl;
import java.util.List;
import model.FruitTransaction;
import service.CreateReportService;
import service.FruitTransactionService;
import service.ReaderService;
import service.StringValidatorService;
import service.WriterService;
import service.impl.CreateReportServiceImpl;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.StringValidatorServiceImpl;
import service.impl.WriterServiceImpl;

public class Main {
    public static void main(String[] args) {
        final String inputFile = "src/main/resources/input.csv";
        final String firstReport = "src/main/resources/report.csv";
        //Read date from file
        ReaderService readerService = new ReaderServiceImpl();
        List<String> listFromFile = readerService.readFromFile(inputFile);
        //Validate strings and fill in a database
        StorageDao storageDao = new StorageDaoImpl();
        StringValidatorService stringValidatorService = new StringValidatorServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        if (stringValidatorService.isStringValid(listFromFile)) {
            for (String oneLine : listFromFile) {
                FruitTransaction transaction = fruitTransactionService
                        .createFruitTransaction(oneLine);
                storageDao.addTransaction(transaction);
            }
        }
        //Create report to file from DB
        WriterService writerService = new WriterServiceImpl();
        CreateReportService createReportService = new CreateReportServiceImpl();
        String report = createReportService.createReport(storageDao.getAllTransaction());
        writerService.writeReport(report, firstReport);
    }
}
