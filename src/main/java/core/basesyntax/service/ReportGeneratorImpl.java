package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.Map;

public class ReportGeneratorImpl implements ReportGenerator {
    private final FruitDao fruitDao;

    public ReportGeneratorImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        Map<String, Integer> balanceInStock = fruitDao.getBalanceInStock();
        StringBuilder reportBuilder = new StringBuilder();
        reportBuilder.append("fruit,quantity\n");

        for (Map.Entry<String, Integer> entry : balanceInStock.entrySet()) {
            String fruitName = entry.getKey();
            Integer quantity = entry.getValue();
            reportBuilder.append(fruitName)
                    .append(",")
                    .append(quantity)
                    .append("\n");
        }
        return reportBuilder.toString();
    }
}
