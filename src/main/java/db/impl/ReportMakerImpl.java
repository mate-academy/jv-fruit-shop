package db.impl;

import db.ReportMaker;
import java.util.Map;
import java.util.Set;
import model.Fruit;

public class ReportMakerImpl implements ReportMaker {
    private static final String HEADER_NAME_FOR_REPORT = "fruit,quantity";

    @Override
    public String reportMaker(Set<Map.Entry<Fruit, Integer>> entrySet) {
        StringBuilder reportMaker = new StringBuilder(HEADER_NAME_FOR_REPORT);
        for (Map.Entry<Fruit, Integer> element : entrySet) {
            reportMaker.append(System.lineSeparator())
                    .append(element.getKey().getName())
                    .append(",")
                    .append(element.getValue());
        }
        return reportMaker.toString();
    }
}
