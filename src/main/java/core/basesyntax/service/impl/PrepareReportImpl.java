package core.basesyntax.service.impl;

import core.basesyntax.dao.ActionsDao;
import core.basesyntax.dao.ActionsDaoImpl;
import core.basesyntax.service.PrepareReport;
import java.util.Map;

public class PrepareReportImpl implements PrepareReport {
    private ActionsDao actionsDao = new ActionsDaoImpl();

    @Override
    public String makeReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity");
        for (Map.Entry<String, Integer> entry : actionsDao.getAllFruits()) {
            builder.append(System.lineSeparator() + entry.getKey() + "," + entry.getValue());
        }
        return builder.toString();

    }
}
