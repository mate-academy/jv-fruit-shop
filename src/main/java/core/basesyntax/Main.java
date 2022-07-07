package core.basesyntax;

import core.db.FruitTransaction;
import core.db.StorageServiceImpl;
import core.service.ReportCreatorService;
import core.service.impl.CsvFileReaderServiceImpl;
import core.service.impl.FileWriterServiceImpl;
import core.service.impl.ReportCreatorServiceImpl;
import core.service.impl.TransactionServiceImpl;
import java.util.List;

public class Main {
    private static final String PATH_DB = "src/resources/transactions.txt";
    private static final String PATH_REPORT = "src/resources/report.txt";

    public static void main(String[] args) {
        List<String> fileData = new CsvFileReaderServiceImpl().readFromFile(PATH_DB);
        List<FruitTransaction> transactions = new TransactionServiceImpl()
                .createFromList(fileData);
        StorageServiceImpl storageService = new StorageServiceImpl();
        transactions.forEach(storageService::addFruit);

        ReportCreatorService fruitService = new ReportCreatorServiceImpl();
        String balance = fruitService.createReport(storageService.getLeftovers());
        new FileWriterServiceImpl().writeToFile(PATH_REPORT, balance);
    }
}
