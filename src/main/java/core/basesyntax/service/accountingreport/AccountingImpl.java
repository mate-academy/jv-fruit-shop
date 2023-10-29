package core.basesyntax.service.accountingreport;

import java.util.Map;

public class AccountingImpl implements Accounting {
    @Override
    public String accountingReport(Map<String, Integer> fruitKindsAndQuantity) {
        StringBuilder builder = new StringBuilder();
        builder.append(FIRST_LINE).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitKindsAndQuantity.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity : " + entry.getKey()
                        + " can't be less than 0");
            }
            builder.append(entry.getKey()).append(COMMA).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

