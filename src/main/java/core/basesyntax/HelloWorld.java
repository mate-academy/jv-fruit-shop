package core.basesyntax;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.calculationservice.ServiceFruits;
import core.basesyntax.service.calculationservice.ServiceFruitsImpl;
import core.basesyntax.service.handler.Balance;
import core.basesyntax.service.handler.HandlerByActivity;
import core.basesyntax.service.handler.Purchase;
import core.basesyntax.service.handler.Return;
import core.basesyntax.service.handler.Supply;
import core.basesyntax.service.handlerservice.HandlerServiceImpl;
import core.basesyntax.service.nio.FileService;
import core.basesyntax.service.nio.FileServiceImpl;
import core.basesyntax.service.parser.TransactionParser;
import core.basesyntax.service.parser.TransactionParserImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */

public class HelloWorld {
    public static final String IN_FILE = "src/main/resources/fruit.csv";
    public static final String OUT_FILE = "src/main/resources/resultFruits.csv";

    public static void main(String[] args) {

        FileService fileService = new FileServiceImpl();
        List<String> stringList = fileService.read(IN_FILE);

        TransactionParser transactionParser = new TransactionParserImpl(new FruitsDaoImpl());
        transactionParser.parser(stringList, "banana", true);
        transactionParser.parser(stringList, "apple", true);

        Map<String, HandlerByActivity> mapStrategy = new HashMap<>();
        mapStrategy.put("b", new Balance());
        mapStrategy.put("p", new Purchase());
        mapStrategy.put("s", new Supply());
        mapStrategy.put("r", new Return());
        ServiceFruits calculationFruits = new ServiceFruitsImpl(new FruitsDaoImpl(),
                new HandlerServiceImpl(mapStrategy));
        String banana = calculationFruits.calculationFruits("banana");
        String apple = calculationFruits.calculationFruits("apple");

        fileService.write(banana, OUT_FILE);
        fileService.write(apple, OUT_FILE);

    }
}
