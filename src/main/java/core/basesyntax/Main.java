package core.basesyntax;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.handler.impl.BalanceHandler;
import core.basesyntax.handler.impl.PurchaseHandler;
import core.basesyntax.handler.impl.ReturnHandler;
import core.basesyntax.handler.impl.SupplyHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileConverter;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.FileWriterService;
import core.basesyntax.service.ReportGeneratorService;
import core.basesyntax.service.impl.FileConverterImpl;
import core.basesyntax.service.impl.FileReaderServiceImpl;
import core.basesyntax.service.impl.FileWriterServiceImpl;
import core.basesyntax.service.impl.ProccessDataImpl;
import core.basesyntax.service.impl.ReportGeneratorServiceImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        final String filePath = "src/main/resources/file.csv";
        final String resultFilePath = "src/main/resources/result.csv";

        final Map<FruitTransaction.Operation, OperationHandler> mapOfHandlers =
                new HashMap<>();
        mapOfHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        mapOfHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        mapOfHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        mapOfHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        final FileReaderService fileReaderService = new FileReaderServiceImpl();
        List<String> dataFromFile = fileReaderService.readFromFile(filePath);

        final FileConverter converterToObjectService = new FileConverterImpl();
        List<FruitTransaction> objectsFromData = converterToObjectService
                .convertToObjects(dataFromFile);

        final OperationStrategy operationStrategy = new OperationStrategyImpl();
        final ProccessDataImpl processData = new ProccessDataImpl(operationStrategy);
        processData.handleOperations(objectsFromData, mapOfHandlers);

        final ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
        String report = reportGenerator.generateReport();

        final FileWriterService fileWriterService = new FileWriterServiceImpl();
        fileWriterService.writeReportToFile(resultFilePath, report);
    }
}
