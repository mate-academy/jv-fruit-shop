package core.service.impl;

import core.model.Fruit;
import core.service.ReportHandlingService;
import core.storage.DataBase;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportHandlingServiceImpl implements ReportHandlingService {
    private static final String CSV_SEPARATOR = ",";
    private static final String HEADER = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> list = new ArrayList<>();
        list.add(HEADER);
        for (Map.Entry<Fruit, Integer> entry : DataBase.stock.entrySet()) {
            list.add(entry.getKey() + CSV_SEPARATOR + entry.getValue());
        }
        return list;
    }
}
