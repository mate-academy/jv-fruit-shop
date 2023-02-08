package core.basesyntax;

import core.basesyntax.dao.FruitsDaoImpl;
import core.basesyntax.service.activity.Balance;
import core.basesyntax.service.activity.CategoryActivity;
import core.basesyntax.service.activity.Purchase;
import core.basesyntax.service.activity.Return;
import core.basesyntax.service.activity.Supply;
import core.basesyntax.service.reader.InputParsingFormatterCsv;
import core.basesyntax.service.reader.InputParsingFormatterCsvImpl;
import core.basesyntax.service.separator.SeparationFruits;
import core.basesyntax.service.separator.SeparationFruitsInImpl;
import core.basesyntax.service.servicefructs.ServiceFruits;
import core.basesyntax.service.servicefructs.ServiceFruitsImpl;
import core.basesyntax.service.strategyactivity.StrategySumByActivityImpl;
import core.basesyntax.service.writefile.OutputParsingFormatterCsv;
import core.basesyntax.service.writefile.OutputParsingFormatterCsvImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
    public static void main(String[] args) {
        InputParsingFormatterCsv parsingFormatter = new InputParsingFormatterCsvImpl();
        List<String> stringList = parsingFormatter.parsingFilesCsv("src/main/resources/fruit.csv");

        SeparationFruits createListFruits = new SeparationFruitsInImpl(new FruitsDaoImpl());
        createListFruits
                .separationFruits(stringList, "banana", true);
        createListFruits
                .separationFruits(stringList, "apple", true);

        Map<String, CategoryActivity> mapStrategy = new HashMap<>();
        mapStrategy.put("b", new Balance());
        mapStrategy.put("p", new Purchase());
        mapStrategy.put("s", new Supply());
        mapStrategy.put("r", new Return());
        ServiceFruits calculationFruits = new ServiceFruitsImpl(new FruitsDaoImpl(),
                new StrategySumByActivityImpl(mapStrategy));
        String banana = calculationFruits.summaryOfTheDay("banana");
        String apple = calculationFruits.summaryOfTheDay("apple");

        String text = banana;

        OutputParsingFormatterCsv outputParsingFormatterCsv = new OutputParsingFormatterCsvImpl();
        outputParsingFormatterCsv.writeFormatCsv(text, "src/main/resources/sashadd.csv");

    }
}
