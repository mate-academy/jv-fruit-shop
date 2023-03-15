package core.basesyntax;

import core.basesyntax.dao.FruitShopDaoImpl;
import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.impl.ConverterDataServiceImpl;
import core.basesyntax.service.impl.CreateReportServiceImpl;
import core.basesyntax.service.impl.FruitServiceImpl;
import core.basesyntax.service.impl.ReaderServiceImpl;
import core.basesyntax.service.impl.WriteDataServiceImpl;
import core.basesyntax.service.operation.OperationHandler;
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
        Map<FruitTransaction.Operation, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.BALANCE, new BalanceOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN, new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.EXPIRED, new ExpiredOperationHandler());

        ReaderServiceImpl readerService = new ReaderServiceImpl();
        String readedDataFromFile = readerService.readData(fromFile);

        ConverterDataServiceImpl converterDataService = new ConverterDataServiceImpl();
        List<String> convertedDataFromFile = converterDataService.convert(readedDataFromFile);

        FruitServiceImpl fruitService = new FruitServiceImpl();
        List<FruitTransaction> fruitTransactionList =
                fruitService.addNewFruit(convertedDataFromFile);

        OperationStrategyImpl operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        for (int i = 0; i < fruitTransactionList.size(); i++) {
            OperationHandler operationHandler = operationStrategy.get(fruitTransactionList.get(i).getOperation());
            operationHandler.operation(fruitTransactionList.get(i));
        }

        CreateReportServiceImpl createReportService = new CreateReportServiceImpl();
        String report = createReportService.createReport(Storage.fruits);

        WriteDataServiceImpl writeDataService = new WriteDataServiceImpl();
        writeDataService.writeDataToFile(report, toFile);
    }
}
