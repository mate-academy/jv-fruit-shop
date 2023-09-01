package core.basesyntax;

import core.basesyntax.service.ConvertService;
import core.basesyntax.service.OperationService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.WriterService;
import core.basesyntax.serviceimpl.BalanceOperationHandler;
import core.basesyntax.serviceimpl.ConvertServiceImpl;
import core.basesyntax.serviceimpl.FruitStrategy;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.PurchaseOperationHandler;
import core.basesyntax.serviceimpl.ReaderServiceImpl;
import core.basesyntax.serviceimpl.ReportService;
import core.basesyntax.serviceimpl.SupplyReturnOperationHandler;
import core.basesyntax.serviceimpl.TransactionServiceImpl;
import core.basesyntax.serviceimpl.WriterServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShop {
    private static final String PATH_TO_READ = "src/main/resources/filename.csv";
    private static final String PATH_TO_WRITE = "src/main/resources/result.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationService> operationHandlers = new HashMap<>();
        operationHandlers.put(FruitTransaction.Operation.SUPPLY,
                new SupplyReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.RETURN,
                new SupplyReturnOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlers.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());

        ReaderService readerService = new ReaderServiceImpl();
        List<String> fileLines = readerService.read(PATH_TO_READ);

        ConvertService convertService = new ConvertServiceImpl();
        List<FruitTransaction> transactions = convertService.convert(fileLines);
        FruitStrategy fruitStrategy = new FruitStrategy(operationHandlers);
        TransactionService processData = new TransactionServiceImpl(fruitStrategy);
        processData.processData(transactions);
        WriterService writerService = new WriterServiceImpl();
        ReportService reportService = new ReportService();

        writerService.writeToFile(PATH_TO_WRITE, reportService.createReport());
    }

}
