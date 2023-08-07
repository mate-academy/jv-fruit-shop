package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    private static final String OUTPUT_TITLE
            = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> createReport() {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = fruitDao.getAll();
        list.add(0, OUTPUT_TITLE);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            list.add(entry.getKey() + "," + entry.getValue());
        }
        return list;
    }
}
