package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.service.ReportMaker;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public List<String> makeReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> report = new ArrayList<>();

        report.add("fruit,quantity");
        Map<String, Integer> storageMap = fruitDao.getMap();
        for (Map.Entry<String, Integer> entry : storageMap.entrySet()) {
            report.add(entry.getKey() + ',' + entry.getValue());
        }
        return report;
    }
}
