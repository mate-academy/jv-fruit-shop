package core.basesyntax;

import core.basesyntax.orderprocessing.CsvFileReader;
import core.basesyntax.orderprocessing.OrdersStorage;
import core.basesyntax.orderprocessing.CsvFileWriter;
import core.basesyntax.orderprocessing.StoreService;
import java.util.Scanner;

public class Executor {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputPath;
        System.out.println("Set the input file path:");
        inputPath = scanner.nextLine();
        System.out.println("Set the output file path:");
        String outputPath;
        outputPath = scanner.nextLine();
        execute(inputPath, outputPath);
    }

    public static void execute(String inputPath, String outputPath) {
        CsvFileReader csvFileReader = new CsvFileReader();
        OrdersStorage ordersStorage = new OrdersStorage();
        StoreService storeService = new StoreService();
        CsvFileWriter csvFileWriter = new CsvFileWriter();
        ordersStorage.addOrders(csvFileReader.formOrders(inputPath));
        storeService.performOperations(ordersStorage.getOrders());
        csvFileWriter.writeResult(outputPath, storeService.formatResult());
    }
}
