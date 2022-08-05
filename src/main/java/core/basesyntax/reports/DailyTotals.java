package core.basesyntax.reports;

import core.basesyntax.dao.DaoHashMap;
import core.basesyntax.file.FileWriterCsv;

public class DailyTotals implements Report {
    @Override
    public void create(String path) {
        new FileWriterCsv().writeFile(path,
                new Queries().totalFruitBalance(new DaoHashMap().getData()));
    }
}
