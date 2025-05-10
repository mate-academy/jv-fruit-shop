package core.basesyntax;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.ShopTransaction;
import core.basesyntax.service.FruitTransactionMap;
import core.basesyntax.service.ReadCsvService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.StrategyOperationService;
import core.basesyntax.service.TransactionProcessor;
import core.basesyntax.service.WriteCsv;
import core.basesyntax.service.impl.FruitTransactionMapImpl;
import core.basesyntax.service.impl.ReadCsvImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.StrategyOperationServiceImpl;
import core.basesyntax.service.impl.TransactionProcessorImpl;
import core.basesyntax.service.impl.WriteCsvImpl;
import core.basesyntax.strategy.BalanceOperation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.PurchaseOperation;
import core.basesyntax.strategy.ReturnOperation;
import core.basesyntax.strategy.SupplyOperation;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String PATH_TO_FILE
            = "src/main/resources/balance.csv";
    private static final String PATH_TO_REPORT_FILE
            = "src/main/resources/reportFile.csv";
    private static final ReadCsvService readerService
            = new ReadCsvImpl();
    private static final FruitTransactionMap parseService
            = new FruitTransactionMapImpl();
    private static final ReportService reportService
            = new ReportServiceImpl();
    private static final WriteCsv writerService
            = new WriteCsvImpl();
    private static StrategyOperationService strategyService;
    private static TransactionProcessor transactionService;

    public static void main(String[] args) {
        Map<OperationType, OperationHandler> operationMap =
                Map.of(OperationType.BALANCE, new BalanceOperation(),
                        OperationType.PURCHASE, new PurchaseOperation(),
                        OperationType.SUPPLY, new SupplyOperation(),
                        OperationType.RETURN, new ReturnOperation());
        List<String> dataFromFile = readerService.readFromFile(PATH_TO_FILE);
        List<ShopTransaction> values = parseService.map(dataFromFile);
        strategyService = new StrategyOperationServiceImpl(operationMap);
        transactionService = new TransactionProcessorImpl(strategyService);
        transactionService.process(values);
        String report = reportService.createReport();
        writerService.writeToFile(PATH_TO_REPORT_FILE,report);
    }
}
