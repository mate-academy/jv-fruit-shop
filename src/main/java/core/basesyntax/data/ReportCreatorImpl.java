package core.basesyntax.data;

import core.basesyntax.storage.FruitDataBase;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    @Override
    public String report(FruitDataBase fruitDataBase) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> entrySet : fruitDataBase.getDataBaseCopy().entrySet()) {
            report.append(entrySet.getKey()).append(", ").append(entrySet.getValue())
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
