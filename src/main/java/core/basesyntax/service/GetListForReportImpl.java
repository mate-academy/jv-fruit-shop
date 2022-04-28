package core.basesyntax.service;

import core.basesyntax.dao.FruitDao;
import java.util.List;

public class GetListForReportImpl implements GetListForReport {
    private static final int HEADER_INDEX = 0;
    private static final String HEADER = "fruit,quantity";
    private FruitDao fruitDao;

    public GetListForReportImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public List<String> getReport() {
        List<String> report = fruitDao.getStorage();
        report.add(HEADER_INDEX, HEADER);
        return report;
    }

}
