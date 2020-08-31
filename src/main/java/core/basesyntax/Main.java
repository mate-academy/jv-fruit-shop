package core.basesyntax;

import core.basesyntax.dao.OrderDao;
import core.basesyntax.dao.OrderDaoImpl;
import core.basesyntax.parser.OrderParser;
import core.basesyntax.parser.ParseOperation;
import core.basesyntax.read.FileReader;
import core.basesyntax.read.FileReaderImpl;
import core.basesyntax.util.TotalFruit;
import core.basesyntax.write.FileWriterServ;
import core.basesyntax.write.WriteFile;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        OrderDao orderDao = new OrderDaoImpl();
        TotalFruit totalFruitOnStorage = new TotalFruit();
        FileReader fileService = new FileReaderImpl();
        ParseOperation parseOperation = new OrderParser();
        List<String> data = fileService.readFile("src/test/resources/test_1.csv");
        for (String row : data) {
            orderDao.add(parseOperation.parseNewOrder(row));
        }
        FileWriterServ recordingService = new WriteFile();
        recordingService.writingToFile("notes1.csv", totalFruitOnStorage.totalFruitOnStorage());
    }
}
