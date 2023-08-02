package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operations.BalanceOperation;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.operations.PurchaseOperation;
import core.basesyntax.operations.ReturnOperation;
import core.basesyntax.operations.SupplyOperation;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportWriter;
import core.basesyntax.service.StrategyService;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.FruitShopServiceImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ReportWriterImpl;
import core.basesyntax.service.impl.StrategyServiceImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String inputDbPath = "src/main/resources/inputDB.csv";
    private static final String reportPath = "src/main/resources/report.csv";

    public static void main(String[] args) {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperation());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperation());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperation());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperation());
        DataReader dataReader = new DataReaderImpl();
        DataParser dataParser = new DataParserImpl();
        FruitShopService fruitShopService = new FruitShopServiceImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportWriter reportWriter = new ReportWriterImpl();
        String dataFromFile = dataReader.readDataFromFile(inputDbPath);
        List<FruitTransaction> transactionList = dataParser.getParsedData(dataFromFile);
        StrategyService strategyService = new StrategyServiceImpl(operationHandlerMap);
        for (FruitTransaction transaction : transactionList) {
            OperationHandler operation = strategyService.getHandler(transaction.getOperation());
            fruitShopService.process(transaction, operation);
        }
        String report = reportCreator.createReport();
        reportWriter.writeReportToFile(report, reportPath);
    }
}
