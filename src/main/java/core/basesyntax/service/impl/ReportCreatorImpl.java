package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.service.ReportCreator;
import java.util.Map;
import java.util.Set;

public class ReportCreatorImpl implements ReportCreator {

    private final FruitTransactionDao fruitTransactionDao;

    public ReportCreatorImpl(FruitTransactionDao fruitTransactionDao) {
        this.fruitTransactionDao = fruitTransactionDao;
    }

    @Override
    public String create() {
        Set<Map.Entry<String,Integer>> nameQuantityMap = fruitTransactionDao.getFull();
        StringBuilder report = new StringBuilder().append("fruit,quantity");

        for (Map.Entry<String, Integer> entry : nameQuantityMap) {
            report.append("\n").append(entry.getKey()).append(",").append(entry.getValue());
        }

        return report.toString();
    }
}
