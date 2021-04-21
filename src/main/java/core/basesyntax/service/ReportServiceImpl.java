package core.basesyntax.service;

import core.basesyntax.dao.ActivityDao;
import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.ReportDao;
import core.basesyntax.model.Activity;
import core.basesyntax.model.Fruit;
import core.basesyntax.model.Report;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    private static final String TITLE = "fruit,quantity" + System.lineSeparator();
    private final ActivityStrategy activityStrategy;
    private final ActivityDao activityDao;
    private final FruitDao fruitDao;
    private final ReportDao reportDao;

    public ReportServiceImpl(ActivityDao activityDao, ActivityStrategy activityStrategy,
                             FruitDao fruitDao, ReportDao reportDao) {
        this.activityDao = activityDao;
        this.activityStrategy = activityStrategy;
        this.fruitDao = fruitDao;
        this.reportDao = reportDao;
    }

    @Override
    public Report generateReport() {
        List<Activity> activities = activityDao.getAll();
        for (Activity activity : activities) {
            activityStrategy.get(activity.getType()).changeBalance(activity.getFruit());
        }
        List<Fruit> allFruits = fruitDao.getAll();
        return reportDao.save(new Report(TITLE, allFruits));
    }
}
