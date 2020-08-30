package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.parser.OrderParse;
import core.basesyntax.parser.ParseOperation;
import core.basesyntax.read.ReadFile;
import core.basesyntax.util.GenerateOrder;
import core.basesyntax.write.FileWriter;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadFile fileService = new ReadFile();
        ParseOperation parseOperation = new OrderParse();
        GenerateOrder generateOrder = new GenerateOrder();
        List<String> data = fileService.readFile("src/test/resources/test_1.csv");
        for (String row : data) {
            Storage.orders.add(generateOrder.newOrder(parseOperation.parse(row)));
        }
        FileWriter recordingService = new FileWriter();
        recordingService.writingToFile();
    }
}
