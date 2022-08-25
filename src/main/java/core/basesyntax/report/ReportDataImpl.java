package core.basesyntax.report;

import core.basesyntax.DataBase;
import java.util.Map;

public class ReportDataImpl implements ReportData {
    private static final int TITLE_INDEX = 0;
    private static final String TITLE = "fruit,quantity";

    @Override
    public String[] createDataReport() {
        String[] strings = new String[DataBase.fruitsAmount.size() + 1];
        strings[TITLE_INDEX] = TITLE;
        int index = 1;
        for (Map.Entry<String, Integer> entry : DataBase.fruitsAmount.entrySet()) {
            strings[index] = entry.getKey() + "," + entry.getValue();
            index++;
        }
        return strings;
    }
}
