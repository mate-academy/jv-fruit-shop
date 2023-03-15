package core.basesyntax;

import core.basesyntax.dao.FruitShopDao;
import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ConverterDataService;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.WriteDataService;
import core.basesyntax.service.impl.ConverterDataServiceImpl;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriteDataServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.OperationStrategy;
import core.basesyntax.service.operation.impl.BalanceOperationHandler;
import core.basesyntax.service.operation.impl.ExpiredOperationHandler;
import core.basesyntax.service.operation.impl.OperationStrategyImpl;
import core.basesyntax.service.operation.impl.PurchaseOperationHandler;
import core.basesyntax.service.operation.impl.ReturnOperationHandler;
import core.basesyntax.service.operation.impl.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String fromFile = "src/main/resources/fruitshop_database.csv";
    private static final String toFile = "src/main/resources/fruitshop_report.csv";

    public static void main(String[] args) {
        FruitShopDao fruitShopDao = new FruitShopDaoImpl();

        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler(fruitShopDao));
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler(fruitShopDao));
        operationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler(fruitShopDao));
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler(fruitShopDao));
        operationHandlerMap.put(FruitTransaction.Operation.EXPIRED,
                new ExpiredOperationHandler(fruitShopDao));

        ReaderService readerService = new ReaderServiceImpl();
        ConverterDataService converterDataService = new ConverterDataServiceImpl();
        FruitService fruitService = new FruitServiceImpl();
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        CreateReportService createReportService = new CreateReportServiceImpl();
        WriteDataService writeDataService = new WriteDataServiceImpl();

        String readedDataFromFile = readerService.readData(fromFile);
        List<String> convertedDataFromFile = converterDataService.convert(readedDataFromFile);
        List<FruitTransaction> fruitTransactionList =
                fruitService.addNewFruit(convertedDataFromFile);
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransactionList.get(i)
                    .getOperation());
            operationHandler.operation(fruitTransactionList.get(i));
        }
        String report = createReportService.createReport(Storage.fruits);
        writeDataService.writeDataToFile(report, toFile);
    }
}
