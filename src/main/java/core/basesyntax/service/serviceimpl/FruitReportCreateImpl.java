package core.basesyntax.service.serviceimpl;

import core.basesyntax.exception.NegativeBalanceException;
import core.basesyntax.service.interfaces.FruitReportCreate;
import java.util.HashMap;
import java.util.Map;

public class FruitReportCreateImpl implements FruitReportCreate {
    private static final String SEMICOL = ",";

    public String createReport(HashMap<String, Integer> fruitQuantity) {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit").append(SEMICOL).append("quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruits: fruitQuantity.entrySet()) {
            if (fruits.getValue() < 0) {
                throw new NegativeBalanceException("Incorrect quantity,"
                        + " some operations probably missing,"
                        + " quantity for fruit"
                        + fruits.getKey()
                        + " is "
                        + fruits.getValue());
            }
            builder.append(fruits.getKey())
                    .append(SEMICOL)
                    .append(fruits.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}
