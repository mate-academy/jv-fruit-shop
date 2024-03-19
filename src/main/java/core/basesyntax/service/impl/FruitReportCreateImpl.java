package core.basesyntax.service.impl;

import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.service.interfaces.FruitReportCreate;
import java.util.HashMap;
import java.util.Map;

public class FruitReportCreateImpl implements FruitReportCreate {
    public String createReport(HashMap<String, Integer> fruitQuantity) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit").append(",").append("quantity");
        for (Map.Entry<String, Integer> fruits: fruitQuantity.entrySet()) {
            if (fruits.getValue() < 0) {
                throw new NegativeBalanceException("Incorrect quantity,"
                        + " some operations probably missing,"
                        + " quantity for fruit"
                        + fruits.getKey()
                        + " is "
                        + fruits.getValue());
            }
            builder.append("\n").append(fruits.getKey()).append(",").append(fruits.getValue());
        }
        return builder.toString();
    }
}
