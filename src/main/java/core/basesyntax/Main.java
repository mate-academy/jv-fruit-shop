package core.basesyntax;

import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.service.fileservice.FileService;
import core.basesyntax.service.fileservice.FileServiceImpl;
import core.basesyntax.service.fruitservice.FruitService;
import core.basesyntax.service.fruitservice.FruitServiceImpl;
import core.basesyntax.service.parser.DataParser;
import core.basesyntax.service.parser.DataParserImpl;
import core.basesyntax.service.report.Report;
import core.basesyntax.service.report.ReportCreatorImpl;
import core.basesyntax.service.strategy.OperationStrategy;
import core.basesyntax.service.strategy.OperationStrategyImpl;
import core.basesyntax.service.strategy.operation.BalanceOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.DecreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.IncreaseOperationHandlerImpl;
import core.basesyntax.service.strategy.operation.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, OperationHandler> operationHandlerMap = new HashMap<>();
        operationHandlerMap.put(FruitRecordDto.OperationType.BALANCE.getType(),
                new BalanceOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.PURCHASE.getType(),
                new DecreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.SUPPLY.getType(),
                new IncreaseOperationHandlerImpl());
        operationHandlerMap.put(FruitRecordDto.OperationType.RETURN.getType(),
                new IncreaseOperationHandlerImpl());
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationHandlerMap);
        String inputFileName = "src/main/resources/inputData.csv";
        String reportFileName = "src/main/resources/report.csv";
        FileService fileService = new FileServiceImpl();
        DataParser dataParser = new DataParserImpl();
        FruitService fruitService = new FruitServiceImpl();
        fruitService.safe(dataParser.parseData(fileService.readDataFromFile(inputFileName)),
                operationStrategy);
        Report report = new ReportCreatorImpl();
        fileService.writeDataToFile(reportFileName, report.createReport());
    }
}
