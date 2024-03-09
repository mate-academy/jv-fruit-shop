package core.basesyntax.service.impl;

import core.basesyntax.dao.RecordDao;
import core.basesyntax.dao.RecordDaoImpl;
import core.basesyntax.model.Product;
import java.util.List;

public class ReportGenerator implements core.basesyntax.service.ReportGenerator {
    private static final String QUANTITY = "quantity";
    private static final String COMMA = ",";
    private final RecordDao recordDao = new RecordDaoImpl();

    @Override
    public String generateReport() {
        List<Product> products = recordDao.getAllFromDB();
        if (products.isEmpty()) {
            throw new RuntimeException("Can't read products from db");
        }
        String header = products.get(0).getClass().getSimpleName().toLowerCase() + COMMA + QUANTITY;
        StringBuilder report = new StringBuilder(header);
        for (Product product : products) {
            report.append(System.lineSeparator()).append(product.getName())
                    .append(COMMA).append(product.getCount());
        }
        return report.toString();
    }
}
