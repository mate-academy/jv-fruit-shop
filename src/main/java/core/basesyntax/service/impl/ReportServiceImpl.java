package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.impl.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<String> generatedReport() {
        FruitDao fruitDao = new FruitDaoImpl();
        List<String> lines = new ArrayList<>();
        lines.add("fruit,quantity");
        List<String> stringList = fruitDao.getAll().stream()
                .map(s -> s.getName()
                        .concat(",")
                        .concat(String.valueOf(s.getQuantity())))
                .collect(Collectors.toList());
        lines.addAll(stringList);
        return lines;
    }
}
