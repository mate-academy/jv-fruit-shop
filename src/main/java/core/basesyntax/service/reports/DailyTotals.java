package core.basesyntax.service.reports;

import core.basesyntax.dao.FruitDaoImpl;

public class DailyTotals implements ReportCreator {
    @Override
    public String create() {
        return new Queries().totalFruitBalance(new FruitDaoImpl().getData());
    }
}
