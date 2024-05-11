package core.basesyntax.services;

import core.basesyntax.dao.FruitsDao;
import java.util.stream.Collectors;

public class ReportGenerator implements ReportService {
    private static final String LINE_SEPARATOR = System.lineSeparator();
    private final FruitsDao fruitsDao;

    public ReportGenerator(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    public String createReport() {
        String header = "fruit,quantity" + LINE_SEPARATOR;
        String body = fruitsDao.getInventory().entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .collect(Collectors.joining(LINE_SEPARATOR));
        return header + body + LINE_SEPARATOR;
    }
}
