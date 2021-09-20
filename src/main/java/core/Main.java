package core;

import core.model.Fruit;
import core.model.Storage;
import core.model.TypeOperations;
import core.service.oparation.BalanceHandler;
import core.service.oparation.OperationHandler;
import core.service.oparation.PurchaseHandler;
import core.service.oparation.ReturnHandler;
import core.service.oparation.SupplyHandler;
import core.service.reader.ReaderService;
import core.service.reader.ReaderServiceImpl;
import core.service.report.FruitRecordDtoParser;
import core.service.report.FruitRecordDtoParserImpl;
import core.service.reporter.ReportGeneratorImpl;
import core.service.validator.ForScannerValidatorImpl;
import core.service.writer.OperationWriter;
import core.service.writer.OperationWriterImpl;
import core.service.writer.ReportWriter;
import core.service.writer.ReportWriterImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final String INPUT_FILE_CSV = "src/main/resources/inputFile.csv";
    private static final String REPORT_FILE_CSV = "src/main/resources/reportFile.csv";

    public static void main(String[] args) {
        writeReportToFile();
        //writeDailyReport(); // My custom method for add new line operation in file.
    }

    private static void writeReportToFile() {
        // Crate Map with operation handlers:
        Map<String, OperationHandler> operationHandlersMap = new HashMap<>();
        operationHandlersMap.put(TypeOperations.BALANCE.get(), new BalanceHandler());
        operationHandlersMap.put(TypeOperations.SUPPLY.get(), new SupplyHandler());
        operationHandlersMap.put(TypeOperations.PURCHASE.get(), new PurchaseHandler());
        operationHandlersMap.put(TypeOperations.RETURN.get(), new ReturnHandler());
        // Add fruits in StorageMap operation handlers:
        Storage.getFruitStorageMap().put(new Fruit("banana"), 0);
        Storage.getFruitStorageMap().put(new Fruit("apple"), 0);
        // Run generate FruitShop report:
        // Read File.
        ReaderService readerService = new ReaderServiceImpl();
        List<String> readFromInputFile = readerService.read(INPUT_FILE_CSV);
        // Parse and add to DB.
        FruitRecordDtoParser fruitRecordDtoParser =
                new FruitRecordDtoParserImpl(operationHandlersMap);
        fruitRecordDtoParser.createFruitRecordDto(readFromInputFile);
        // Create report.
        ReportGeneratorImpl fruitShop = new ReportGeneratorImpl();
        String reportString = fruitShop.createReport();
        // Write report ro File.
        ReportWriter reportWriter = new ReportWriterImpl();
        reportWriter.write(REPORT_FILE_CSV, reportString);
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
