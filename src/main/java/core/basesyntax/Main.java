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
    private static final ReaderOperationService readerOperation = new ReaderOperationServiceImpl();
    private static final DataTransactionService dataTransaction = new DataTransactionServiceImpl();
    private static final UpdateDataStorageService updateStorage =
            new UpdateDataStorageServiceImpl();
    private static final ReportBuilderService buildReport = new ReportBuilderServiceImpl();

    private static final WriterOperationService writerOperation = new WriterOperationServiceImpl();

    public static void main(String[] args) {
        String data = readerOperation.readDataFromFile("src/main/resources/data.csv");
        List<FruitTransaction> fruitTransactions = dataTransaction.getData(data);
        updateStorage.updateData(fruitTransactions);
        String report = buildReport.buildReport();
        writerOperation.writeData(report,"src/main/resources/report.csv");
    }
}
