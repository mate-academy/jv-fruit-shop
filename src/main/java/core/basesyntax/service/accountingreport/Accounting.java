package core.basesyntax.service.accountingreport;

import java.util.Map;

public interface Accounting {
    String COMMA = ",";
    String HEADER = "fruit,quantity";
    String makeReport(Map<String, Integer> fruitKindsAndQuantity);
}
