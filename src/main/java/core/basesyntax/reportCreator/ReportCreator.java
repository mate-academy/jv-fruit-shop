package core.basesyntax.reportCreator;

import core.basesyntax.Operation;
import core.basesyntax.Storage;
import core.basesyntax.operationStrategy.OperationStrategy;

import java.util.Map;

import core.basesyntax.FruitTransaction;


public class ReportCreator {
    public String generateReport(Storage storage) {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : storage.getFruits().entrySet()) {
            report.append(entry.getKey()).append(",").append(entry.getValue()).append("\n");
        }
        return report.toString();
    }

}


//type,fruit,quantity
//        b,banana,20
//        b,apple,100
//        s,banana,100
//        p,banana,13
//        r,apple,10
//        p,apple,20
//        p,banana,5
//        s,banana,50