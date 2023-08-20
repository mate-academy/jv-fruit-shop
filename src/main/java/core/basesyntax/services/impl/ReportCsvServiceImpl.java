package core.basesyntax.services.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.services.ReportCsvService;
import core.basesyntax.util.ConstantsForCsvParse;
import java.util.Map;

public class ReportCsvServiceImpl implements ReportCsvService {
    private static String TITLE_VALUE = "fruit,quantity";
    private static final int TITLE_VALUE_SIZE = 1;
    private static Storage fruitDB;

    public ReportCsvServiceImpl(Storage fruitDB) {
        this.fruitDB = fruitDB;
    }

    @Override
    public String[] createReport() {
        Map<String, Integer> reportMap = fruitDB.getStorageFruits();
        String[] reportWrite = new String[reportMap.size() + TITLE_VALUE_SIZE];
        int index = 0;
        reportWrite[index] = TITLE_VALUE;
        for (Map.Entry<String, Integer> entry : reportMap.entrySet()) {
            ++index;
            reportWrite[index] = System.lineSeparator()
                    + entry.getKey() + ConstantsForCsvParse.COMMA + entry.getValue();
        }
        return reportWrite;
    }
}
