package core.basesyntax;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import core.basesyntax.service.FileReaderService;
import core.basesyntax.service.impl.CsvFileReaderService;
import core.basesyntax.strategy.Strategy;
import core.basesyntax.strategy.impl.BalanceStrategy;
import core.basesyntax.strategy.impl.PurchaseStrategy;
import core.basesyntax.strategy.impl.ReturnStrategy;
import core.basesyntax.strategy.impl.SupplyStrategy;

public class Main {
    public static void main(String[] args) {
        File folder = new File("src/main/resources");
        File inputFile = new File(folder, "input.csv");

        FileReaderService csvFileReaderService = new CsvFileReaderService();
        List<String> strings = csvFileReaderService.read(inputFile);

        /**
         *     b - balance, the remnants of fruits at the beginning of the working day
         *     s - supply, means you are receiving new fruits from suppliers
         *     p - purchase, means someone has bought some fruit
         *     r - return, means someone who have bought the fruits now returns them back
         */
        Map<String, Strategy> operationStrategies = new HashMap<>();
        operationStrategies.put("b", new BalanceStrategy());
        operationStrategies.put("s", new SupplyStrategy());
        operationStrategies.put("p", new PurchaseStrategy());
        operationStrategies.put("r", new ReturnStrategy());
    }
}
