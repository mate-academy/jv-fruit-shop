package core.basesyntax.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    public static final List<String> listDb = new ArrayList<>();
    public static final Map<String,Integer> mapDb = new HashMap<>();
    private static final String DATA_FILE_PATH = "./src/main"
            + "/java/core/basesyntax/database/beginningData";
    private static final String REPORT_FILE_PATH = "./src/main"
            + "/java/core/basesyntax/database/report";

    public String getReportFilePath() {
        return REPORT_FILE_PATH;
    }

    public String getDataFilePath() {
        return DATA_FILE_PATH;
    }
}
