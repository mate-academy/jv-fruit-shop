package core.basesyntax.services;

import core.basesyntax.dao.FruitsDao;

public class ReportGenerator implements ReportService {
    private static final String HEADER = "fruit,quantity";
    private final FruitsDao fruitsDao;

    public ReportGenerator(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    public String createReport() {
        StringBuilder sb = new StringBuilder(HEADER)
                .append(System.lineSeparator());
        fruitsDao.getInventory()
                .entrySet()
                .stream()
                .map(entry -> entry.getKey() + "," + entry.getValue())
                .forEach(entry -> sb
                        .append(entry)
                        .append(System.lineSeparator()));
        return sb.toString();
    }
}
