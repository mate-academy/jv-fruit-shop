package core.basesyntax;

import core.basesyntax.service.ActionReader;
import core.basesyntax.service.CsvHandler;
import core.basesyntax.service.CsvHandlerImpl;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> shopStock;
        String from = "src/main/resources/test.csv";
        String to = "src/main/resources/";
        ActionReader actionReader = new ActionReader();
        CsvHandler csvHandler = new CsvHandlerImpl();
        shopStock = actionReader.inputDataToMap(from);
        csvHandler.report(shopStock, to);
    }
}
