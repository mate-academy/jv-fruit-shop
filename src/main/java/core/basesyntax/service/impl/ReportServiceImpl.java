package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final String TABLE_HEADER = "fruits,quantity";
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();
    private final WriteServiceImpl writeService = new WriteServiceImpl();

    @Override
    public void createReport() {
        List<String> collect = fruitDao.getDataBaseContent().entrySet().stream()
                .map(e -> new StringBuilder(e.getKey()).append(",").append(e.getValue()).toString())
                .sorted()
                .collect(Collectors.toList());

        collect.add(FIRST_ELEMENT_INDEX, TABLE_HEADER);

        writeService.write(collect);
    }
}
