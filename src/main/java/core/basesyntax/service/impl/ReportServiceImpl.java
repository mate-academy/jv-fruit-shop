package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDaoImpl;
import core.basesyntax.service.ReportService;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final int FIRST_ELEMENT_INDEX = 0;
    private static final String TABLE_HEADER = "fruits,quantity";
    private final FruitDaoImpl fruitDao = new FruitDaoImpl();
    private final FileWriterImpl writeService = new FileWriterImpl();

    @Override
    public void createReport() {
        List<String> report = fruitDao.getDataBaseContent().entrySet().stream()
                .map(e -> e.getKey() + "," + e.getValue())
                .sorted()
                .collect(Collectors.toList());

        report.add(FIRST_ELEMENT_INDEX, TABLE_HEADER);

        writeService.write(report);
    }
}
