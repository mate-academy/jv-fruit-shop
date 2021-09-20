package core.basesyntax;

import operations.*;
import reporter.ReportCreator;
import reporter.ReportCreatorImpl;

import java.util.HashMap;
import java.util.Map;

import static db.FruitShop.fruitShop;

/**
 * Feel free to remove this class and create your own.
 */
public class HelloWorld {
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
