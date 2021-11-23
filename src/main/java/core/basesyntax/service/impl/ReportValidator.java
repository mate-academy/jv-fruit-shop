package core.basesyntax.service.impl;

import core.basesyntax.service.Validator;
import java.util.List;

public class ReportValidator implements Validator {
    private static final String DATA_FORMAT = "[bspr],(\\w+),(\\d+)";
    private static final String TITLE = "type,fruit,quantity";
    private static final int TITLE_INDEX = 0;

    public boolean test(List<String> list) {
        if (!list.get(TITLE_INDEX).equals(TITLE)) {
            throw new RuntimeException("Invalid data in input file - missing title line");
        }
        for (int i = 1; i < list.size(); i++) {
            String line = list.get(i);
            if (!(line.trim().matches(DATA_FORMAT))) {
                throw new RuntimeException("Invalid data in input file");
            }
        }
        return true;
    }
}
