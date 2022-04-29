package core.basesyntax.service.impl;

import core.basesyntax.dao.StorageDao;
import core.basesyntax.dao.StorageDaoImpl;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.ReportGeneratorService;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ReportGeneratorServiceImpl implements ReportGeneratorService {
    private StorageDao storageDao = new StorageDaoImpl();

    @Override
    public String report() {
        List<String> report = new ArrayList<>();
        report.add("fruit,quantity");
        for (Map.Entry<Fruit, Integer> entry : storageDao.getStorage().entrySet()) {
            report.add(entry.getKey().getFruit() + "," + entry.getValue().toString());
        }

        return convertListToString(report);
    }

    private String convertListToString(List<String> inputList) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : inputList) {
            stringBuilder.append(s).append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
