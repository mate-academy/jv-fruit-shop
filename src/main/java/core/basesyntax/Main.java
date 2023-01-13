package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataTransactionService;
import core.basesyntax.service.ReaderOperationService;
import core.basesyntax.service.ReportBuilderService;
import core.basesyntax.service.UpdateDataStorageService;
import core.basesyntax.service.WriterOperationService;
import core.basesyntax.service.impl.DataTransactionServiceImpl;
import core.basesyntax.service.impl.ReaderOperationServiceImpl;
import core.basesyntax.service.impl.ReportBuilderServiceImpl;
import core.basesyntax.service.impl.UpdateDataStorageServiceImpl;
import core.basesyntax.service.impl.WriterOperationServiceImpl;
import java.util.List;

public class Main {
    private static final String READ_FROM_FILE = "src/main/resources/data.csv";
    private static final String WRITE_TO_FILE = "src/main/resources/report.csv";

    public static void main(String[] args) {
        ReaderOperationService readerOperation = new ReaderOperationServiceImpl();
        DataTransactionService dataTransaction = new DataTransactionServiceImpl();
        UpdateDataStorageService updateStorage = new UpdateDataStorageServiceImpl();
        ReportBuilderService buildReport = new ReportBuilderServiceImpl();
        WriterOperationService writerOperation = new WriterOperationServiceImpl();

        String data = readerOperation.readDataFromFile(READ_FROM_FILE);
        List<FruitTransaction> fruitTransactions = dataTransaction.turnDataToTransactions(data);
        updateStorage.updateData(fruitTransactions);
        String report = buildReport.buildReport();
        writerOperation.writeData(report,WRITE_TO_FILE);
    }
}
