package core.basesyntax;

import dao.FruitStorageDao;
import dao.impl.FruitStorageDaoImpl;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import service.FruitTransactionService;
import service.ReaderService;
import service.ReportService;
import service.StringValidatorService;
import service.WriterService;
import service.impl.FruitTransactionServiceImpl;
import service.impl.ReaderServiceImpl;
import service.impl.ReportServiceImpl;
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
        FruitStorageDao fruitStorageDao = new FruitStorageDaoImpl();
        StringValidatorService stringValidatorService = new StringValidatorServiceImpl();
        FruitTransactionService fruitTransactionService = new FruitTransactionServiceImpl();
        if (stringValidatorService.isStringValid(listFromFile)) {
            for (String oneLine : listFromFile) {
                FruitTransaction transaction = fruitTransactionService
                        .createFruitTransaction(oneLine);
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
