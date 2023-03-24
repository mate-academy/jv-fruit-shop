package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParseService;
import core.basesyntax.service.ReadDataService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.ParseServiceImpl;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReadDataServiceImpl;
import core.basesyntax.service.impl.ReportServiceImpl;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.service.impl.WriteToFileServiceImpl;
import core.basesyntax.strategy.FruitShopStrategy;
import core.basesyntax.strategy.impl.FruitShopStrategyImpl;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_DATE_NAME = "src/main/resources/FruitShopData.csv";
    private static final String FILE_REPORT_NAME = "src/main/resources/FruitShopReport.csv";

    public static void main(String[] args) throws IOException {
        Map<Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        ReadDataService readDataService = new ReadDataServiceImpl();
        ParseService parser = new ParseServiceImpl();
        FruitShopStrategy fruitShopStrategyImpl =
                new FruitShopStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportServiceImpl();
        WriteToFileService writeToFileService = new WriteToFileServiceImpl();
        List<String> data = readDataService.readFromFile(FILE_DATE_NAME);
        List<FruitTransaction> fruitTransactionList = parser.getFruitTransactions(data);
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = fruitShopStrategyImpl.get(transaction.getOperation());
            handler.handle(transaction);
        }
        String report = reportService.getReport();
        writeToFileService.writeToFile(report, FILE_REPORT_NAME);
    }
}
