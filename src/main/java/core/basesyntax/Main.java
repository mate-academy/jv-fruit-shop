package core.basesyntax;

import core.basesyntax.strategy.ActionReaderStrategy;
import core.basesyntax.service.CsvManager;
import core.basesyntax.service.CsvManagerImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> shopStock;
        String from = "src/main/resources/test.csv";
        String to = "src/main/resources/";
        ActionReaderStrategy actionReader = new ActionReaderStrategy();
        CsvManager csvHandler = new CsvManagerImpl();
        shopStock = actionReader.inputDataToMap(from);
        csvHandler.report(shopStock, to);
    }
}
