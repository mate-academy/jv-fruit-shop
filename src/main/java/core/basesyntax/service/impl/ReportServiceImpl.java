package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ReportServiceImpl implements ReportService {

    @Override
    public List<String> createReport() {
        {
            List<String> reportList = new ArrayList<>();
            Set<Map.Entry<Fruit,Integer>> entrySet = Storage.fruitStorage.entrySet();
            for (Map.Entry<Fruit,Integer> each : entrySet) {
                reportList.add(each.getKey().toString() + "," + each.getValue());
            }
            return reportList;
        }

    }
}
