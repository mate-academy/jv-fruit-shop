package core.basesyntax;

import static db.FruitShop.fruitShop;

import java.util.HashMap;
import java.util.Map;
import operations.Operation;
import operations.OperationBalance;
import operations.OperationPurchase;
import operations.OperationReturn;
import operations.OperationStrategy;
import operations.OperationStrategyImpl;
import operations.OperationSupply;
import reporter.ReportCreator;
import reporter.ReportCreatorImpl;

/**
 * Feel free to remove this class and create your own.
 */
public class FruitShopMain {
    public static void main(String[] args) {
        Map<String, Operation> operationMap = new HashMap<>();
        operationMap.put("s", new OperationSupply());
        operationMap.put("r", new OperationReturn());
        operationMap.put("b", new OperationBalance());
        operationMap.put("p", new OperationPurchase());
        OperationStrategy strategy = new OperationStrategyImpl(operationMap);
        ReportCreator creator = new ReportCreatorImpl(strategy);
        String fromFile = "src/main/resources/rightInputFile.csv";
        String toFile = "src/main/resources/outputFile";
        creator.createReport(fromFile, toFile);
        System.out.println(fruitShop);
    }
}
