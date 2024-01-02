package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.FruitService;
import core.basesyntax.services.fileprocessing.DbBalancePutter;
import core.basesyntax.services.fileprocessing.FileDataReader;
import core.basesyntax.services.fileprocessing.FileWriter;
import core.basesyntax.services.fileprocessing.OtherOperationsGetter;
import core.basesyntax.services.fileprocessing.ReportGenerator;
import core.basesyntax.services.fileprocessing.impl.DbBalancePutterImpl;
import core.basesyntax.services.fileprocessing.impl.FileDataReaderCsvImpl;
import core.basesyntax.services.fileprocessing.impl.FileWriterImpl;
import core.basesyntax.services.fileprocessing.impl.FruitServiceImpl;
import core.basesyntax.services.fileprocessing.impl.OtherOperationsGetterImpl;
import core.basesyntax.services.fileprocessing.impl.ReportGeneratorImpl;
import core.basesyntax.services.handlers.OperationHandler;
import core.basesyntax.services.handlers.impl.PurchaseOperationHandler;
import core.basesyntax.services.handlers.impl.ReturnOperationHandler;
import core.basesyntax.services.handlers.impl.SupplyOperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static DbBalancePutter dbBalancePutter;
    private static FileDataReader fileDataReader;
    private static List<String> rawData;
    private static OtherOperationsGetter otherOperationsGetter;
    private static FruitService fruitService;
    private static FileWriter fileWriter;
    private static Map<String, OperationHandler> operationHandlerMap;
    private static ReportGenerator reportGenerator;
    private static OperationStrategy operationStrategy;

    public static void main(String[] args) {
        initVars();
        dbBalancePutter.putBalanceDataToDb(dbBalancePutter.getBalanceData(rawData));
        fruitService.runOtherOperationsOverFruit(
                otherOperationsGetter.writeDownOtherOperations(rawData), operationStrategy);
        fileWriter.writeToFile(reportGenerator.generateReport(Storage.getFruitsTypeAndAmount()));
    }

    private static void initVars() {
        dbBalancePutter = new DbBalancePutterImpl();
        fileDataReader = new FileDataReaderCsvImpl();
        rawData = fileDataReader.readFromFileAndHoldData("src/main/resources/SampleSourceCSV.csv");
        fruitService = new FruitServiceImpl();
        otherOperationsGetter = new OtherOperationsGetterImpl();
        operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitTransaction.Operation.PURCHASE.getCode(),
                new PurchaseOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.RETURN.getCode(),
                new ReturnOperationHandler());
        operationHandlerMap.put(FruitTransaction.Operation.SUPPLY.getCode(),
                new SupplyOperationHandler());
        operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        fileWriter = new FileWriterImpl();
        reportGenerator = new ReportGeneratorImpl();
    }
}
