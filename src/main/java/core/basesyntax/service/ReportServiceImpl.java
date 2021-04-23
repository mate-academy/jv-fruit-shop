package core.basesyntax.service;

import core.basesyntax.dao.ActivityDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.Report;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private final ActivityDao activityDao;
    private final FruitDao fruitDao;
    private final ReportDao reportDao;
    private final ActivityService activityService;

    public ReportServiceImpl(ActivityDao activityDao, FruitDao fruitDao,
                             ReportDao reportDao, ActivityService activityService) {
        this.activityDao = activityDao;
        this.fruitDao = fruitDao;
        this.reportDao = reportDao;
        this.activityService = activityService;
    }

    @Override
    public Report generateReport() {
        activityService.analyze(activityDao.getAll());
        return reportDao.save(new Report(TITLE, fruitDao.getAll()));
    }
}
