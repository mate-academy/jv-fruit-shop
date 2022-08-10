package core.basesyntax.service.reports;

import core.basesyntax.dao.FruitDao;

public class ReportServiceImp implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImp(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String create() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("fruit,quantity");
        fruitDao.getData().forEach((key, value) -> stringBuffer
                .append(System.lineSeparator()).append(key).append(",").append(value));
        return stringBuffer.toString();
    }
}
