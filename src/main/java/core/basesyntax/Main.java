package core.basesyntax;

import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.TransactionConvertor;
import core.basesyntax.service.TransactionService;
import core.basesyntax.service.activity.BalanceTransactionHandler;
import core.basesyntax.service.activity.PurchaseTransactionHandler;
import core.basesyntax.service.activity.ReturnTransactionHandler;
import core.basesyntax.service.activity.SupplyTransactionHandler;
import core.basesyntax.service.activity.TransactionHandler;
import core.basesyntax.strategy.ActivityStrategy;
import core.basesyntax.strategy.ActivityStrategyImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_NAME = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_NAME = "src/main/resources/output.csv";

    public static void main(String[] args) {
        FruitDaoImpl fruitDao = new FruitDaoImpl();
        Map<FruitTransaction.Operation, TransactionHandler> activityHandlerMap = Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceTransactionHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseTransactionHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnTransactionHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyTransactionHandler(fruitDao));
        ReportService reportService = new ReportService(fruitDao);
        ActivityStrategy activityStrategy = new ActivityStrategyImpl(activityHandlerMap);
        TransactionService transactionService = new TransactionService(activityStrategy, fruitDao);
        FileService fileService = new FileService();
        List<String> inputFileLines = fileService.readFromFile(INPUT_FILE_NAME);
        TransactionConvertor transactionConvertor = new TransactionConvertor();
        List<FruitTransaction> fruitTransactions =
                transactionConvertor.convertToTransactionsList(inputFileLines);
        transactionService.executeTransactions(fruitTransactions);
        String report = reportService.generateReport();
        fileService.writeToFile(OUTPUT_FILE_NAME, report);
    }
}
