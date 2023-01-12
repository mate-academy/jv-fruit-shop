package core.basesyntax;

import core.basesyntax.Dao.FruitDao;
import core.basesyntax.Dao.FruitDaoImpl;
import core.basesyntax.Model.FruitTransaction;
import core.basesyntax.Service.FileWorkWith.CSVFileReaderService;
import core.basesyntax.Service.FileWorkWith.CSVFileReaderServiceImpl;
import core.basesyntax.Service.FileWorkWith.CSVFileWriterService;
import core.basesyntax.Service.FileWorkWith.CSVFileWriterServiceImpl;
import core.basesyntax.Service.TransactionOperations.FruitTransactionCreationService;
import core.basesyntax.Service.TransactionOperations.FruitTransactionCreationServiceImpl;
import core.basesyntax.Service.TransactionOperations.FruitTransactionReportMaker;
import core.basesyntax.Service.TransactionOperations.FruitTransactionReportMakerImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVFileReaderService fileReaderService = new CSVFileReaderServiceImpl();
        CSVFileWriterService fileWriterService = new CSVFileWriterServiceImpl();
        FruitDao dao = new FruitDaoImpl();
        FruitTransactionCreationService transactionService
                = new FruitTransactionCreationServiceImpl(dao);
        FruitTransactionReportMaker reportMaker = new FruitTransactionReportMakerImpl();

        List<String[]> fileData = fileReaderService
                .readFile("src/main/resources/readFromFile.csv");
        transactionService.createTransactions(fileData);
        List<FruitTransaction> report = reportMaker.makeReport(dao);
        fileWriterService.writeToFile("src/main/resources/storeToFile.csv", report);
    }
}
