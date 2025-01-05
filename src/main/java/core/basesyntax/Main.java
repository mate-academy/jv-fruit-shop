package core.basesyntax;

import core.basesyntax.operationhandlers.ReturnOperationHandler;
import core.basesyntax.operationhandlers.BalanceOperationHandler;
import core.basesyntax.operationhandlers.OperationHandler;
import core.basesyntax.operationhandlers.PurchaseOperationHandler;
import core.basesyntax.operationhandlers.SupplyOperationHandler;
import core.basesyntax.services.DataProcessing;
import core.basesyntax.services.FileDataReader;
import core.basesyntax.services.FileDataWriter;
import core.basesyntax.services.ReportGenerator;
import core.basesyntax.services.impl.DataProcessingImpl;
import core.basesyntax.services.impl.FileDataReaderImpl;
import core.basesyntax.services.impl.FileDataWriterImpl;
import core.basesyntax.services.impl.ReportGeneratorImpl;
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
        // 1. Читання вхідних даних з файлу
        FileDataReader fileDataReader = new FileDataReaderImpl();
        List<String> inputData = fileDataReader.readData(Path.of(INPUT_PATH));

        // 2. Ініціалізація об'єкта Storage
        Storage storage = new Storage();

        // 3. Ініціалізація обробників операцій
        operationMap.put(Operation.BALANCE, new BalanceOperationHandler(storage));
        operationMap.put(Operation.SUPPLY, new SupplyOperationHandler(storage));
        operationMap.put(Operation.PURCHASE, new PurchaseOperationHandler(storage));
        operationMap.put(Operation.RETURN, new ReturnOperationHandler(storage));

        // 4. Ініціалізація стратегії обробки операцій
        OperationStrategy operationStrategy = new OperationStrategyImpl(operationMap);

        // 5. Ініціалізація обробки даних
        DataProcessing dataProcessing = new DataProcessingImpl((OperationStrategyImpl)
                operationStrategy, storage);

        // 6. Обробка вхідних даних
        List<String> processedData = dataProcessing.processData(inputData);

        // 7. Генерація звіту
        ReportGenerator generator = new ReportGeneratorImpl();
        String report = generator.getReport(processedData);

        // 8. Запис результату у файл
        FileDataWriter fileDataWriter = new FileDataWriterImpl(Path.of(OUTPUT_PATH));
        File outputFile = fileDataWriter.writeData(report);

        // 9. Виведення результату
        System.out.println("Data processing complete. Output file: "
                + outputFile.getAbsolutePath());
    }
}
