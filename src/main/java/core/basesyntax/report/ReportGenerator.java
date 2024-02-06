package core.basesyntax.report;

import core.basesyntax.model.Fruit;

import java.util.List;
import java.util.Map;

public interface ReportGenerator {
    public List<String> generateReport(Map<Fruit, Integer> storage);
//    public String genReport(Map<String, Integer> fruitStorage, String fileName);


}
