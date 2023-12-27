package core.basesyntax.service.impl;

import core.basesyntax.products.Goods;
import core.basesyntax.service.DatabaseDaoService;
import core.basesyntax.service.ReportCreationService;
import java.util.List;

public class ReportCreationServiceImpl implements ReportCreationService {
    private static final String CSV_FIRST_LINE = "product,quantity" + System.lineSeparator();
    private static final DatabaseDaoService databaseDao = new DatabaseDaoServiceImpl();
    private static final StringBuilder reportStringBuilder = new StringBuilder(CSV_FIRST_LINE);

    @Override
    public String createReport() {
        List<Goods> dataInfo = databaseDao.getAll();
        for (Goods goods : dataInfo) {
            reportStringBuilder.append(goods.getName()).append(",")
                    .append(goods.getAmount()).append(System.lineSeparator());
        }
        return reportStringBuilder.toString();
    }
}
