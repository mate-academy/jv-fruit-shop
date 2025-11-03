package core.basesyntax.service.report;

import core.basesyntax.dao.StorageDao;

public class ReportGeneratorImpl implements ReportGenerator {
    private final StorageDao storageDao;

    public ReportGeneratorImpl(StorageDao storageDao) {
        this.storageDao = storageDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder("fruit,quantity\n");
        storageDao.getAll().forEach(
                (fruit, quantity) ->
                report.append(fruit.getFruitName())
                        .append(",")
                        .append(quantity)
                        .append("\n")
        );
        return report.toString();
    }
}
