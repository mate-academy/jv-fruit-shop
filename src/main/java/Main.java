import db.Storage;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.FruitTransaction;
import operations.OperationHandler;
import operations.impl.BalanceOperationHandler;
import operations.impl.PurchaseOperationHandler;
import operations.impl.ReturnOperationHandler;
import operations.impl.SupplyOperationHandler;
import service.DataProcessorService;
import service.FileReaderService;
import service.OperationStrategy;
import service.ReportGeneratorService;
import service.ReportWriterService;
import service.impl.DataProcessorServiceImpl;
import service.impl.FileReaderServiceImpl;
import service.impl.OperationStrategyImpl;
import service.impl.ReportGeneratorServiceImpl;
import service.impl.ReportWriterServiceImpl;

public class Main {
    public static void main(String[] args) {

        // Ініціалізуємо storage для збереження даних про фрукти та
        Storage storage = new Storage();

        Map<FruitTransaction.Operation,OperationHandler> operationOperationHandlerMap =
                new HashMap<>();

        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,
                new BalanceOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,
                new PurchaseOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,
                new ReturnOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,
                new SupplyOperationHandler());
        // Ініціалізуємо об'єкт для читання даних з файлу
        FileReaderService fileReaderService =
                new FileReaderServiceImpl("src/main/resources/input.csv");
        try {
            // Отримаємо рядки даних з файлу
            List<String> inputLines = fileReaderService.readFromFile();
            // Ініціалізуємо стратегію обробки операцій
            OperationStrategy operationStrategy =
                    new OperationStrategyImpl(operationOperationHandlerMap);
            // Ініціалізуємо об'єкт для обробки даних
            DataProcessorService dataProcesorService =
                    new DataProcessorServiceImpl(storage,operationStrategy);
            // Обробляємо дані з файлу
            dataProcesorService.process(inputLines);
            // Ініціалізуємо об'єкт для генерації звіту
            ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl(storage);
            // Отримуємо звіт
            String report = reportGeneratorService.generateReport();
            // Ініціалізуємо об'єкт для запису звіту у файл
            ReportWriterService reportWriterService =
                    new ReportWriterServiceImpl("src/main/resources/output.csv");
            // Записуємо звіт у файл
            reportWriterService.writeReportToFile(report);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
