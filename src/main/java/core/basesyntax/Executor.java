package core.basesyntax;

import core.basesyntax.orderprocessing.OrdersReader;
import core.basesyntax.orderprocessing.OrdersStorage;
import core.basesyntax.orderprocessing.ResultWriter;
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
        OrdersReader ordersReader = new OrdersReader();
        OrdersStorage ordersStorage = new OrdersStorage();
        StoreService storeService = new StoreService();
        ResultWriter resultWriter = new ResultWriter();
        ordersStorage.addOrders(ordersReader.formOrders(inputPath));
        storeService.performOperations(ordersStorage.getOrders());
        resultWriter.writeResult(outputPath, storeService.formatResult());
    }
}
