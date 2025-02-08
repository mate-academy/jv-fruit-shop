package core.basesyntax.services;

import core.basesyntax.models.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorImp implements ReportGenerator {
    @Override
    public List<String> generateReport() {
        Map<String, Integer> fruits = Storage.getFruits();
        List<String> data = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            data.add(entry.getKey() + "," + entry.getValue());
        }
        return data;
    }
}
