package core.basesyntax.service.impl;

import core.basesyntax.service.interfaces.CombineOutput;
import java.util.Map;

public class CombineOutputImpl implements CombineOutput {
    @Override
    public String combineOutput(Map<String, Integer> shop) {
        String result = "fruit,quantity";
        for (Map.Entry<String, Integer> record : shop.entrySet()) {
            result = result + "\n" + record.getKey() + "," + record.getValue();
        }
        return result;
    }
}
