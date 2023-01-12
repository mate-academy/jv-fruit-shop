package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.transactionOperations.FruitTransactionCreationService;
import core.basesyntax.service.transactionOperations.FruitTransactionCreationServiceImpl;
import core.basesyntax.service.fileWorkWith.CSVFileReaderService;
import core.basesyntax.service.fileWorkWith.CSVFileReaderServiceImpl;
import core.basesyntax.service.fileWorkWith.CSVFileWriterService;
import core.basesyntax.service.fileWorkWith.CSVFileWriterServiceImpl;
import core.basesyntax.service.transactionOperations.FruitTransactionReportMaker;
import core.basesyntax.service.transactionOperations.FruitTransactionReportMakerImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CSVFileReaderService fileReaderService = new CSVFileReaderServiceImpl();
        CSVFileWriterService fileWriterService = new CSVFileWriterServiceImpl();
        FruitDao dao = new FruitDaoImpl();
        FruitTransactionCreationService transactionService = new FruitTransactionCreationServiceImpl(dao);
        FruitTransactionReportMaker reportMaker = new FruitTransactionReportMakerImpl();

        List<String[]> fileData = fileReaderService.readFile("src/main/resources/readFromFile.csv");
        transactionService.createTransactions(fileData);
        List<FruitTransaction> report = reportMaker.makeReport(dao);
        fileWriterService.writeToFile("src/main/resources/storeToFile.csv", report);
    }
}
