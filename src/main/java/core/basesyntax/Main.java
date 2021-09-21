package core.basesyntax;

import core.basesyntax.impl.DataParserImpl;
import core.basesyntax.impl.FruitStorageServiceImpl;
import core.basesyntax.impl.ReaderServiceImpl;
import core.basesyntax.impl.ReportCreatorImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.FruitRecordDto;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.operation.OperationHandlerBalanceImpl;
import core.basesyntax.operation.OperationHandlerPurchaseImpl;
import core.basesyntax.operation.OperationHandlerReturnImpl;
import core.basesyntax.operation.OperationHandlerSupplyImpl;
import core.basesyntax.operation.OperationStrategy;
import core.basesyntax.operation.OperationStrategyImpl;
import core.basesyntax.operation.OperationType;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.ReaderService;
import core.basesyntax.service.ReportCreator;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class Main {
    private static final String fromPath = "src/main/resources/inputFile.csv";
    private static final String toPath = "src/main/resources/dayReport.csv";
    private static final LocalDate date = LocalDate.now();

    public static void main(String[] args) {
        ReaderService reader = new ReaderServiceImpl();
        List<FruitRecordDto> fruitsDto = reader.read(fromPath);

        Map<OperationType, OperationHandler> operationMap = new HashMap<>();
        operationMap.put(OperationType.BALANCE, new OperationHandlerBalanceImpl());
        operationMap.put(OperationType.PURCHASE, new OperationHandlerPurchaseImpl());
        operationMap.put(OperationType.RETURN, new OperationHandlerReturnImpl());
        operationMap.put(OperationType.SUPPLY, new OperationHandlerSupplyImpl());
        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        DataParser parser = new DataParserImpl(strategy);
        Map<Fruit, Integer> fruitsMap = parser.parseDto(fruitsDto);

        FruitStorageServiceImpl storageService = new FruitStorageServiceImpl();
        storageService.addToStorage(fruitsMap);

        ReportCreator creator = new ReportCreatorImpl();
        creator.createReport(toPath, date);
        System.out.println("Your report wait you in src/main/resources, name as: outputFile.csv");
    }
}

