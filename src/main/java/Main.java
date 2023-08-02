import db.Storage;
import model.*;
import operations.*;
import operations.impl.*;
import service.*;
import service.impl.*;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        // Ініціалізуємо storage для збереження даних про фрукти та
        Storage storage = new Storage();

        Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap = new HashMap<>();

        operationOperationHandlerMap.put(FruitTransaction.Operation.BALANCE,new BalanceOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.PURCHASE,new PurchaseOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.RETURN,new ReturnOperationHandler());
        operationOperationHandlerMap.put(FruitTransaction.Operation.SUPPLY,new SupplyOperationHandler());

        // Ініціалізуємо об'єкт для читання даних з файлу
        FileReaderService fileReaderService = new FileReaderServiceImpl("src/main/resources/input.csv");

        try {
            // Отримаємо рядки даних з файлу
            List<String> inputLines = fileReaderService.readFromFile();

            // Ініціалізуємо стратегію обробки операцій
            OperationStrategy operationStrategy = new OperationStrategyImpl(operationOperationHandlerMap);

            // Ініціалізуємо об'єкт для обробки даних
            DataProcesorService dataProcesorService = new DataProcessorServiceImpl(storage,operationStrategy);

            // Обробляємо дані з файлу
            dataProcesorService.process(inputLines);

            // Ініціалізуємо об'єкт для генерації звіту
            ReportGeneratorService reportGeneratorService = new ReportGeneratorServiceImpl(storage);
            System.out.println(storage);

            // Отримуємо звіт
            String report = reportGeneratorService.generateReport();

            // Ініціалізуємо об'єкт для запису звіту у файл
            ReportWriterService reportWriterService = new ReportWriterServiceImpl("src/main/resources/output.csv");

            // Записуємо звіт у файл
            reportWriterService.writeReportToFile(report,"src/main/resources/output.csv");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}