package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.operationhandlers.BalanceOperationHandler;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.operationhandlers.ReturnOperationHandler;
import core.basesyntax.operationhandlers.SupplyOperationHandler;
import core.basesyntax.services.DataProcessing;
import core.basesyntax.services.FileDataReader;
import core.basesyntax.services.FileDataWriter;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.ShopService;
import core.basesyntax.services.impl.DataProcessingImpl;
import core.basesyntax.services.impl.FileDataReaderImpl;
import core.basesyntax.services.impl.FileDataWriterImpl;
import core.basesyntax.services.impl.ReportGeneratorImpl;
import core.basesyntax.services.impl.ShopServiceImpl;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.io.File;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_PATH = "src/main/resources/output.csv";
    private static Map<Operation, OperationHandler> operationMap = new HashMap<>();

    public static void main(String[] args) {
        FileDataReader fileDataReader = new FileDataReaderImpl();
        List<String> inputData = fileDataReader.readData(Path.of(INPUT_PATH));

        Storage storage = new Storage();

        operationMap.put(Operation.BALANCE, new BalanceOperationHandler());
        operationMap.put(Operation.SUPPLY, new SupplyOperationHandler());
        operationMap.put(Operation.PURCHASE, new PurchaseOperationHandler());
        operationMap.put(Operation.RETURN, new ReturnOperationHandler());

        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        DataProcessing dataProcessing = new DataProcessingImpl((OperationStrategyImpl)
                operationStrategy, storage);

        ShopService shopService = new ShopServiceImpl(storage);
        List<FruitTransaction> processedData = dataProcessing.processData(inputData);
        shopService.operations(processedData);

        ReportGenerator generator = new ReportGeneratorImpl(storage);
        String report = generator.getReport();

        FileDataWriter fileDataWriter = new FileDataWriterImpl(Path.of(OUTPUT_PATH));
        File outputFile = fileDataWriter.writeData(report, OUTPUT_PATH);

        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
