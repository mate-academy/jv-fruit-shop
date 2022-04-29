package db;

import java.util.Map;
import java.util.Set;
import model.Fruit;

public class ReportMaker {
    private static final String HEADER_NAME_FOR_REPORT = "fruit,quantity";

    public StringBuilder reportMaker(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder reportMaker = new StringBuilder(HEADER_NAME_FOR_REPORT);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            reportMaker.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(",")
                    .append(element.getValue());
        }
        return reportMaker;
    }
}
