package core;

import core.controller.FruitShop;
import core.model.Fruit;
import core.model.TypeOperations;
import core.service.oparation.BalanceHandler;
import core.service.oparation.OperationHandler;
import core.service.oparation.PurchaseHandler;
import core.service.oparation.ReturnHandler;
import core.service.oparation.SupplyHandler;
import core.service.validator.ForScannerValidatorImpl;
import core.service.writer.OperationWriter;
import core.service.writer.OperationWriterImpl;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeReportToFile();
        writeDailyReport();
    }

    private static void writeReportToFile() {
        // Crate Map with operation handlers:
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(TypeOperations.BALANCE.get(), new BalanceHandler());
        operationHandlersMap.put(TypeOperations.SUPPLY.get(), new SupplyHandler());
        operationHandlersMap.put(TypeOperations.PURCHASE.get(), new PurchaseHandler());
        operationHandlersMap.put(TypeOperations.RETURN.get(), new ReturnHandler());
        // Add fruits in StorageMap operation handlers:
        FruitShop.STORAGE.getFruitStorageMap().put(new Fruit("banana"), 0);
        FruitShop.STORAGE.getFruitStorageMap().put(new Fruit("apple"), 0);
        // Run generate FruitShop report:
        FruitShop fruitShop = new FruitShop(operationHandlersMap);
        fruitShop.writeReport();
    }

    private static void writeDailyReport() {
        // My custom method for add new line operation in file.
        String myDailyInputFileCsv = "src/main/resources/MyDailyInputFile.csv";
        OperationWriter operationWriter = new OperationWriterImpl();
        ForScannerValidatorImpl validator = new ForScannerValidatorImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть операцію так: b,apple,17");
        System.out.println("Введіть для завершення: Exit");
        String stringToDailyReport = scanner.nextLine();
        while (!stringToDailyReport.equals("Exit")) {
            System.out.println("Ви ввели: " + stringToDailyReport);
            if (validator.checkIsValid(stringToDailyReport)) {
                operationWriter.write(stringToDailyReport, myDailyInputFileCsv);
            }
            stringToDailyReport = scanner.nextLine();
        }
        System.out.println("Exit!");
    }
}
