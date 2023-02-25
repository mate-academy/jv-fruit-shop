package core.basesyntax.service.report;

import core.basesyntax.dao.FruitsDao;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private FruitsDao fruitsDao;

    public ReportServiceImpl(FruitsDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public String reportAllFruits() {
        return fruitsDao.getAllFruits().entrySet().stream().map(t -> t.getKey()
                        .concat(",")
                        .concat(String.valueOf(t.getValue())))
                .collect(Collectors.joining("\n"));
    }
}
