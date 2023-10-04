package core.basesyntax;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.mapper.FruitTransactionMapper;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.strategy.FruitService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.FruitServiceImpl;
import core.basesyntax.strategy.impl.OperationHandlerStrategyImpl;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String READ_FILE_PATH
            = "src/main/java/resources/FruitStore_Data.csv";
    private static final String WRITE_FILE_PATH
            = "src/main/java/resources/FruitStore_Report.csv";

    public static void main(String[] args) {
        System.out.println("-----------------------");
        System.out.println("-  --= Fuit shop =--  -");
        System.out.println("-----------------------");
        FileReader fruitReader = new CsvFileReaderImpl();
        List<String> linesFromFile = fruitReader.readFile(READ_FILE_PATH);
        FruitTransactionMapper mapper = new FruitTransactionMapper();
        List<Transaction> transactions = mapper.mapToTransactions(linesFromFile);
        StorageDao storage = new StorageDaoImpl();
        FruitService fruitService = new FruitServiceImpl(storage);
        Map<Transaction.Operation, OperationHandler> operationHandlers =
                Map.of(Transaction.Operation.BALANCE, new BalanceOperationHandler(fruitService),
                        Transaction.Operation.SUPPLY, new SupplyOperationHandler(fruitService),
                        Transaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitService),
                        Transaction.Operation.RETURN, new ReturnOperationHandler(fruitService)
        );
        OperationHandlerStrategy strategy = new OperationHandlerStrategyImpl(operationHandlers);
        TransactionProcessor processor = new TransactionProcessorImpl(strategy);
        processor.process(transactions);
        ReportService reportService = new ReportServiceImpl();
        String report = reportService.generateReport(storage.getAll());
        CsvFileWriterImpl fileWriter = new CsvFileWriterImpl();
        fileWriter.writeFile(WRITE_FILE_PATH, report);
    }
}
