package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GenerateReport {

    public List<String> generateReport(Map<String,Integer> storage) {
        List<String> result = new ArrayList<>();
        result.add("fruit,quantity");
        for (Map.Entry<String,Integer> entry : storage.entrySet()) {
            result.add(entry.getKey() + "," + entry.getValue());
        }
        return result;
    }
}
