package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> generatedReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> storageList = fruitDao.getAll().stream()
                .map(s -> s.getName()
                        .concat(",")
                        .concat(String.valueOf(s.getQuantity())))
                .collect(Collectors.toList());

        storageList.add(0, "fruit,quantity");
        return storageList;
    }
}
