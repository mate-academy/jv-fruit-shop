package db;

import java.util.HashMap;
import java.util.Map;
import model.Fruit;

public class Storage {
    private Map<String, Integer> reportData = new HashMap<>();

    public void addDataToReport(Fruit fruit) {
        reportData.put(fruit.getFruit(), fruit.getQuantity());
    }

    public Map<String, Integer> getReportData() {
        return reportData;
    }
}
