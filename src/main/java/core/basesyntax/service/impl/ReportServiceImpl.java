package core.basesyntax.service.impl;

import core.basesyntax.dao.FruitTransactionDao;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ReportService;
import core.basesyntax.service.WriteScvService;

public class ReportServiceImpl implements ReportService {
    private FruitTransactionDao fruitTransactionDao;
    private WriteScvService writeScvService;
    private final String nameReportFile = "report.csv";
    private StringBuilder data;

    public ReportServiceImpl(FruitTransactionDao fruitTransactionDao,
                             WriteScvService writeScvService) {
        this.fruitTransactionDao = fruitTransactionDao;
        this.writeScvService = writeScvService;
    }

    @Override
    public void createReport() {
        data = new StringBuilder("fruit,quantity\n");
        for (FruitTransaction fruit : fruitTransactionDao.getAllListDb()) {
            data.append(fruit.getFruit()).append(",").append(fruit.getQuantity()).append("\n");
        }
        writeScvService.writeDataScvFile(data.toString(), nameReportFile);
    }
}
