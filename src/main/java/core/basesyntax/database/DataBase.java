package core.basesyntax.database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {
    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public static final List<String> listDb = new ArrayList<>();
    public static final Map<String,Integer> mapDb = new HashMap<>();
    private static final String DATA_FILE_PATH = "./src/main/resources/beginningData";
    private static final String REPORT_FILE_PATH = "./src/main/resources/report";

    public String getReportFilePath() {
        return REPORT_FILE_PATH;
    }

    public String getDataFilePath() {
        return DATA_FILE_PATH;
    }
}
