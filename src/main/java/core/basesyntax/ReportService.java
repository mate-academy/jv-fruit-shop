package core.basesyntax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ReportService {
    public Map<String, String> toGetReport(Storage storage, List<String> types) {
        Map<String, String> resultReport = new HashMap<>();
        for (String type : types) {
            int sumOfType = storage.getFruitPackages()
                    .stream()
                    .filter(position -> position.getType().equals(type))
                    .mapToInt(FruitPackage::getAmount)
                    .sum();
            resultReport.put(type, String.valueOf(sumOfType));
        }
        return resultReport;
    }
}
