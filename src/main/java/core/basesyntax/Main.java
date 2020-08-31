package core.basesyntax;

import core.basesyntax.service.FileService;
import dto.Order;
import java.util.ArrayList;
import java.util.List;
import parsers.OrderParser;

public class Main {

    public static void main(String[] args) {
        Storage storage = new Storage();
        ProductCalculator orderAnalyzer = new ProductCalculator(storage);
        FileService fileService = new FileService();
        List<String> file = fileService.readFile("src/main/resources/info.csv");
        OrderParser parser = new OrderParser();
        List<Order> orders = new ArrayList<>();
        for (String line : file) {
            orders.add(parser.parse(line));
        }
        orderAnalyzer.ordersToStorage(orders);
        fileService.writeToFile(storage.getReport(), "src/main/resources/output.csv");
    }
}
