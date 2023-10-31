package core.basesyntax;

import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import model.Operation;
import service.FruitTransactionService;
import service.OperationStrategy;
import service.Reporter;
import serviceimpl.FruitPackerImpl;
import serviceimpl.FruitTransactionServiceImpl;
import serviceimpl.OperationStrategyImpl;
import serviceimpl.ReaderImpl;
import serviceimpl.ReporterImpl;
import serviceimpl.WriterImpl;
import strategy.BalanceOperation;
import strategy.Operating;
import strategy.PurchaseOperation;
import strategy.ReturnOperation;
import strategy.SupplyOperation;

public class Main {
    public static final String SOURCE_FILE_NAME = "src/main/resources/sourceFile.csv";
    public static final String RESULT_FILE_NAME = "src/main/resources/resultFile.csv";
    private static final Map<Operation, Operating> operationsMap = Map.of(
            Operation.SUPPLY, new SupplyOperation(),
            Operation.BALANCE, new BalanceOperation(),
            Operation.RETURN, new ReturnOperation(),
            Operation.PURCHASE, new PurchaseOperation()
    );

    public static void main(String[] args) {
        List<String> transactionsStringList = new ReaderImpl().readDataFromFile(SOURCE_FILE_NAME);
        List<FruitTransaction> transactionsList = new FruitPackerImpl()
                .makeList(transactionsStringList);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationsMap);
        FruitTransactionService fruitTransactionService
                = new FruitTransactionServiceImpl(operationStrategy);
        fruitTransactionService.processFruitTransactions(transactionsList);
        Reporter reportService = new ReporterImpl();
        List<String> dailyTransactionsReport = reportService.report();
        new WriterImpl().writeToFile(dailyTransactionsReport, RESULT_FILE_NAME);
    }
}
