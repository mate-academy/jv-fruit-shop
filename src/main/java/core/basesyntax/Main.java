package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import java.util.List;

public class Main {

    private static final String SOURCE_FILE_PATH = "src/main/resources/data.csv";
    private static final String RESULT_FILE_PATH = "src/main/resources/result.csv";

    public static void main(String[] args) {
        ReaderService readerService = new ReaderServiceImpl();
        List<FruitTransaction> fruitTransactionList = readerService
                .getTransactions(SOURCE_FILE_PATH);

        OperationService operationService = new FruitShopServiceImpl();
        StorageDao fruitStorage = operationService.processOperations(fruitTransactionList);
        ReportService reportService = new ReportServiceImpl();
        List<String> fruitReport = reportService.makeReport(fruitStorage);

        FileWriter writer = new FileWriterImpl();
        writer.writeLines(RESULT_FILE_PATH, fruitReport);
    }
}
