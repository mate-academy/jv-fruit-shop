package core.basesyntax;

import core.basesyntax.dao.FileReaderDao;
import core.basesyntax.dao.FileReaderDaoImpl;
import core.basesyntax.dao.FileWriterDao;
import core.basesyntax.dao.FileWriterImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.OperationType;
import core.basesyntax.model.TransactionDto;
import core.basesyntax.service.CreateReportService;
import core.basesyntax.service.CreateReportServiceImpl;
import core.basesyntax.service.FruitShopService;
import core.basesyntax.service.FruitShopServiceImpl;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.OperationStrategyImpl;
import core.basesyntax.service.ParseDataServiceImpl;
import core.basesyntax.service.ParseFileDataService;
import core.basesyntax.service.operation.BalanceOperationHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseOperationHandler;
import core.basesyntax.service.operation.ReturnOperationHandler;
import core.basesyntax.service.operation.SupplyOperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/java/fruitbase.csv";
    private static final String REPORT_NAME = "src/main/java/fruitReport.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getType(), new BalanceOperationHandler());
        operationHandlerMap.put(OperationType.SUPPLY.getType(), new SupplyOperationHandler());
        operationHandlerMap.put(OperationType.PURCHASE.getType(), new PurchaseOperationHandler());
        operationHandlerMap.put(OperationType.RETURN.getType(), new ReturnOperationHandler());
        FileReaderDao readFile = new FileReaderDaoImpl();
        List<String> inputData = readFile.getDataFromFile(FROM_FILE_NAME);
        ParseFileDataService parseFileDataService = new ParseDataServiceImpl();
        List<TransactionDto> operationTypeList = parseFileDataService.parseData(inputData);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        Map<Fruit, Integer> reportMap = fruitShopService.transact(operationTypeList,
                operationStrategy);
        CreateReportService createReportService = new CreateReportServiceImpl();
        String report = createReportService.createReport(reportMap, REPORT_NAME);
        FileWriterDao writeToFile = new FileWriterImpl();
        writeToFile.writeToFile(report, REPORT_NAME);
    }
}
