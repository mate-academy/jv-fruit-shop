package core.basesyntax;

import java.util.Map;

public class ReportGenerationImpl implements ReportGenerationMet {
    @Override
    public String reportGeneration(Map<String, Integer> fruits) {
        StringBuilder strBuild = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<String, Integer> entry : fruits.entrySet()) {
            String fruitToAdd = entry.getKey() + "," + String.valueOf(entry.getValue());
            strBuild.append(fruitToAdd).append("\n");
        }
        return strBuild.toString();
    }
}
