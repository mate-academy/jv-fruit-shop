package core.basesyntax.service;

import java.util.Map;

public class CombineStringFromMapImpl implements CombineStringFromMap {
    @Override
    public String combineString(Map<String, Integer> shop) {
        String result = "fruit,quantity";
        for (Map.Entry<String, Integer> record : shop.entrySet()) {
            result = result + "\n" + record.getKey() + "," + record.getValue();
        }
        return result;
    }
}
