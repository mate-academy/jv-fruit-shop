package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitsDao;
import core.basesyntax.service.ReportCreator;
import java.util.ArrayList;
import java.util.Map;

public class ReportCreatorImpl implements ReportCreator {
    private String header;
    private FruitsDao fruitsDao;

    public ReportCreatorImpl(String header, FruitsDao fruitsDao) {
        this.header = header;
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String create(Map<String, Integer> data) {
        ArrayList<String> fruits = new ArrayList<>(fruitsDao.getAll().keySet());
        StringBuilder reportBuilder = new StringBuilder(header);
        for (String fruit : fruits) {
            reportBuilder.append(System.lineSeparator())
                    .append(fruit)
                    .append(",")
                    .append(data.get(fruit));
        }
        return reportBuilder.toString();
    }
}
