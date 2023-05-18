package core.basesyntax.process;

import core.basesyntax.model.Storage;
import java.util.Map;

public class FruitReportMakerImpl implements FruitReportMaker {
    private static final String INITIAL_LINE = "fruits, quantity\n";
    private static final String DELIM = ",";
    private static final String NEW_LINE = "\n";

    @Override
    public String makeFruitReport() {
        StringBuilder resultReport = new StringBuilder();
        resultReport.append(INITIAL_LINE);
        for (Map.Entry<String, Integer> entry : Storage.fruits.entrySet()) {
            resultReport.append(entry.getKey())
                    .append(DELIM)
                    .append(entry.getValue())
                    .append(NEW_LINE);
        }
        return resultReport.toString();
    }
}
