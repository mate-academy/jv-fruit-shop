package core.basesyntax;

import core.basesyntax.model.Fruit;
import core.basesyntax.services.ActionInterface;
import core.basesyntax.services.FruitParser;
import core.basesyntax.services.ShopInterfaceStrategy;
import core.basesyntax.services.impl.Parser;
import core.basesyntax.services.impl.Writer;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.List;

public class FruitShop {
    private final String path;
    private Storage storage;
    private static final String STOCK_FILE = "src/main/resources/stock.csv";

    public FruitShop(String path) {
        this.path = path;
        storage = new Storage();
    }

    public void start() {
        Writer writer = new Writer(STOCK_FILE);
        FruitParser fruitParser = new Parser();
        for (List<String> row : fruitParser.readFile(path)) {
            ActionInterface action = new ShopInterfaceStrategy(storage).get(row.get(0));
            if (action != null) {
                Fruit fruit =
                        new Fruit(row.get(1), checkBalance(row.get(2)), checkDate(row.get(3)));
                action.action(fruit);
            }
        }
        writer.doWrite(storage);
    }

    private LocalDate checkDate(String string) {
        try {
            return LocalDate.parse(string);
        } catch (DateTimeException e) {
            throw new RuntimeException("Date error " + string);
        }
    }

    private Integer checkBalance(String string) {
        try {
            return Integer.parseInt(string);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Amount specified in file error " + string);
        }
    }
}
