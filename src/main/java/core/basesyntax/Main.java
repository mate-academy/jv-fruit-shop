package core.basesyntax;

import core.basesyntax.dao.FileReader;
import core.basesyntax.dao.FileReaderImpl;
import core.basesyntax.dao.FileWriter;
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
import core.basesyntax.service.TransactionDtoParser;
import core.basesyntax.service.TransactionDtoParserImpl;
import core.basesyntax.service.operation.BalanceHandler;
import core.basesyntax.service.operation.OperationHandler;
import core.basesyntax.service.operation.PurchaseHandler;
import core.basesyntax.service.operation.ReturnHandler;
import core.basesyntax.service.operation.SupplyHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String FROM_FILE_NAME = "src/main/java/fruitbase.csv";
    private static final String REPORT_NAME = "src/main/java/fruitReport.csv";

    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(OperationType.BALANCE.getType(), new BalanceHandler());
        operationHandlerMap.put(OperationType.SUPPLY.getType(), new SupplyHandler());
        operationHandlerMap.put(OperationType.PURCHASE.getType(), new PurchaseHandler());
        operationHandlerMap.put(OperationType.RETURN.getType(), new ReturnHandler());
        FileReader readFile = new FileReaderImpl();
        List<String> inputData = readFile.getDataFromFile(FROM_FILE_NAME);
        TransactionDtoParser parseFileDataService = new TransactionDtoParserImpl();
        List<TransactionDto> operationTypeList = parseFileDataService.parseData(inputData);
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        FruitShopService fruitShopService = new FruitShopServiceImpl(operationStrategy);
        Map<Fruit, Integer> reportMap = fruitShopService.transact(operationTypeList,
                operationStrategy);
        CreateReportService createReportService = new CreateReportServiceImpl();
        String report = createReportService.createReport(reportMap, REPORT_NAME);
        FileWriter writeToFile = new FileWriterImpl();
        writeToFile.writeToFile(report, REPORT_NAME);
    }
}
