package core.basesyntax.service.accountingreport;

import java.util.Map;

public interface Accounting {
    String COMMA = ",";
    String FIRST_LINE = "fruit,quantity";
    String accountingReport(Map<String, Integer> fruitKindsAndQuantity);
}
