package core;

import core.controller.FruitShop;
import core.model.MyConstants;
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
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(TypeOperations.B.toString().toLowerCase(), new BalanceHandler());
        operationHandlersMap.put(TypeOperations.S.toString().toLowerCase(), new SupplyHandler());
        operationHandlersMap.put(TypeOperations.P.toString().toLowerCase(), new PurchaseHandler());
        operationHandlersMap.put(TypeOperations.R.toString().toLowerCase(), new ReturnHandler());
        FruitShop fruitShop = new FruitShop(operationHandlersMap);
        fruitShop.writeReport();
    }

    private static void writeDailyReport() {
        OperationWriter operationWriter = new OperationWriterImpl();
        ForScannerValidatorImpl validator = new ForScannerValidatorImpl();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть операцію так: b,apple,17");
        System.out.println("Введіть для завершення: Exit");
        String stringToDailyReport = scanner.nextLine();
        while (!stringToDailyReport.equals("Exit")) {
            System.out.println("Ви ввели: " + stringToDailyReport);
            if (validator.checkIsValid(stringToDailyReport)) {
                operationWriter.write(stringToDailyReport, MyConstants.MY_DAILY_INPUT_FILE_CSV);
            }
            stringToDailyReport = scanner.nextLine();
        }
        System.out.println("Exit!");
    }
}
