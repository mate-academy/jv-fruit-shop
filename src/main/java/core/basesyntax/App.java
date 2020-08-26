package core.basesyntax;

import core.basesyntax.services.FruitShopService;
import core.basesyntax.services.operations.Buy;
import core.basesyntax.services.operations.Operable;
import core.basesyntax.services.operations.Return;
import core.basesyntax.services.operations.Supply;
import java.util.HashMap;
import java.util.Map;

public class App {
    private static final String FILE_PATH = "src/test/resources/inputFile.txt";
    private static final String RESULT_FILE_PATH = "src/test/resources/resultFile.txt";
    private static final String SUCCESSFUL_MESSAGE
            = "file processed successfully, output file was created";
    private static final String UNSUCCESSFUL_MESSAGE
            = "file processed successfully, output file was created";
    private static final String SUPPLY = "s";
    private static final String BUY = "b";
    private static final String RETURN = "r";

    public static void main(String[] args) {
        FruitShopService shopFileService = new FruitShopService();
        if (shopFileService.processFile(FILE_PATH,
                RESULT_FILE_PATH, createOperationsMap())) {
            System.out.println(SUCCESSFUL_MESSAGE);
        } else {
            System.out.println(UNSUCCESSFUL_MESSAGE);
        }
    }

    private static Map<String, Operable> createOperationsMap() {
        Map<String, Operable> map = new HashMap<>();
        map.put(RETURN, new Return());
        map.put(SUPPLY, new Supply());
        map.put(BUY, new Buy());
        return map;
    }
}
