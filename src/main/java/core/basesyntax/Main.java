package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.file_work_with.CsvFileReaderService;
import core.basesyntax.service.file_work_with.CsvFileReaderServiceImpl;
import core.basesyntax.service.file_work_with.CsvFileWriterService;
import core.basesyntax.service.file_work_with.CsvFileWriterServiceImpl;
import core.basesyntax.service.transaction_operations.FruitTransactionCreationService;
import core.basesyntax.service.transaction_operations.FruitTransactionCreationServiceImpl;
import core.basesyntax.service.transaction_operations.FruitTransactionReportMaker;
import core.basesyntax.service.transaction_operations.FruitTransactionReportMakerImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CsvFileReaderService fileReaderService = new CsvFileReaderServiceImpl();
        CsvFileWriterService fileWriterService = new CsvFileWriterServiceImpl();
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
