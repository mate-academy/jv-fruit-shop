package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import core.basesyntax.service.ParserService;
import core.basesyntax.service.ReadDataService;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteToFileService;
import core.basesyntax.service.impl.BalanceOperationHandler;
import core.basesyntax.service.impl.PurchaseOperationHandler;
import core.basesyntax.service.impl.ReturnOperationHandler;
import core.basesyntax.service.impl.SupplyOperationHandler;
import core.basesyntax.strategy.impl.FruitShopStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FILE_DATE_NAME = "src/main/resources/FruitShopData.csv";
    private static final String FILE_REPORT_NAME = "src/main/resources/FruitShopReport.csv";
    private static final String OPERATION_BALANCE = "b";
    private static final String OPERATION_PURCHASE = "p";
    private static final String OPERATION_RETURN = "r";
    private static final String OPERATION_SUPPLY = "s";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OPERATION_BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(OPERATION_PURCHASE, new PurchaseOperationHandler());
        operationHandlerMap.put(OPERATION_RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(OPERATION_SUPPLY, new SupplyOperationHandler());
        ReadDataService readDataService = new ReadDataService();
        ParserService parser = new ParserService();
        FruitShopStrategyImpl fruitShopStrategyImpl =
                new FruitShopStrategyImpl(operationHandlerMap);
        ReportService reportService = new ReportService();
        WriteToFileService writeToFileService = new WriteToFileService();
        List<String> data = readDataService.readFromFile(FILE_DATE_NAME);
        List<FruitTransaction> fruitTransactionList = parser.getFruitTransaction(data);
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = fruitShopStrategyImpl.get(transaction.getOperation());
            handler.handle(transaction);
        }
        String report = reportService.getReport(Storage.storage);
        writeToFileService.writeToFile(report, FILE_REPORT_NAME);
    }
}
