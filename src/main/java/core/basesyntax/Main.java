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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Map<FruitTransaction.Operation, OperationHandler> mapOfHandlers =
            new HashMap<>();
    private static final String filePath = "src/main/resources/file.csv";
    private static final String resultFilePath = "src/main/resources/result.csv";
    private static final FileReaderService fileReaderService = new FileReaderServiceImpl();
    private static final FileConverter converterToObjectService = new FileConverterImpl();
    private static final ProccessDataImpl processData = new ProccessDataImpl();
    private static final ReportGeneratorService reportGenerator = new ReportGeneratorServiceImpl();
    private static final FileWriterService fileWriterService = new FileWriterServiceImpl();

    public static void main(String[] args) {
        mapOfHandlers.put(FruitTransaction.Operation.BALANCE, new BalanceHandler());
        mapOfHandlers.put(FruitTransaction.Operation.PURCHASE, new PurchaseHandler());
        mapOfHandlers.put(FruitTransaction.Operation.RETURN, new ReturnHandler());
        mapOfHandlers.put(FruitTransaction.Operation.SUPPLY, new SupplyHandler());

        List<String> dataFromFile = fileReaderService.readFromFile(filePath);

        List<FruitTransaction> objectsFromData = converterToObjectService
                .convertToObjects(dataFromFile);

        processData.handleOperations(objectsFromData, mapOfHandlers);

        String report = reportGenerator.generateReport();

        fileWriterService.writeReportToFile(resultFilePath, report);
    }
}
