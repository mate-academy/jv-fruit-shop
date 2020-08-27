package core.basesyntax;

import core.basesyntax.stock.db.Storage;
import core.basesyntax.stock.manipulation.GenerateOrder;
import core.basesyntax.stock.parser.OrderParse;
import core.basesyntax.stock.read.ReadFile;
import core.basesyntax.stock.write.WriteToFile;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderParse dataParse = new OrderParse();
        GenerateOrder generateOrder = new GenerateOrder();
        ReadFile fileServiceInt = new ReadFile();
        List<String> data = fileServiceInt.readFile("src/test/resources/test_3.csv");
        for (String row : data) {
            Storage.orders.add(generateOrder.newOrder(dataParse.parse(row)));
        }
        WriteToFile recordingService = new WriteToFile();
        recordingService.writingToFile();
    }
}
