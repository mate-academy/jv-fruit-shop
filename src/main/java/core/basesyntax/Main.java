package core.basesyntax;

import core.basesyntax.dao.ProductDao;
import core.basesyntax.dao.impl.ProductDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReportCreatorService;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReportCreatorServiceImpl;
import core.basesyntax.service.impl.TransactionServiceImpl;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_READ_FROM = "src/main/resources/data.csv";
    private static final String FILE_WRITE_TO = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<FruitTransaction.Operation, OperationHandler> handlers = new HashMap<>();
        handlers.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        handlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler());
        handlers.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        handlers.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        OperationHandlerStrategy operationStrategy =
                new OperationHandlerStrategy(handlers);

        FileReaderService fileReader = new FileReaderServiceImpl();
        List<String> fileLines = fileReader.readFromFile(FILE_READ_FROM);

        TransactionService transactionService = new TransactionServiceImpl();
        List<FruitTransaction> transactions = transactionService.createTransactions(fileLines);

        FruitService fruitService = new FruitServiceImpl(operationStrategy);
        fruitService.handleTransactions(transactions);

        ProductDao productDao = new ProductDaoImpl();
        ReportCreatorService reportCreatorService = new ReportCreatorServiceImpl();
        List<String> report = reportCreatorService.createReport(productDao.getAllProducts());

        FileWriterService fileWriter = new FileWriterServiceImpl();
        fileWriter.writeToFile(FILE_WRITE_TO, report);
    }
}
