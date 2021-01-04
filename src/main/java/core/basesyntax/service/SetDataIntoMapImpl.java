package core.basesyntax.service;

import java.util.List;
import java.util.Map;

public class SetDataIntoMapImpl implements SetDataIntoMap {
    @Override
    public void setDataIntoMap(Map<String, Integer> shop, List<String> data) {
        for (String line : data) {
            String[] record = line.split(",");
            new DoOperationImpl().doOperation(shop, record[0], record[1], record[2]);
        }
    }
}
