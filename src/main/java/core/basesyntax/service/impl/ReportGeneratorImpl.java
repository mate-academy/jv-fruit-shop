package core.basesyntax.service.impl;

import core.basesyntax.db.FruitDao;
import core.basesyntax.service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String REPORT_HEAD = "fruit,quantity";
    private final FruitDao fruitDb;

    public ReportGeneratorImpl(FruitDao fruitDb) {
        this.fruitDb = fruitDb;
    }

    @Override
    public String[] generate() {
        List<String> result = new ArrayList<>();
        result.add(REPORT_HEAD);
        for (String fruit: fruitDb.getAllFruits()) {
            int count = fruitDb.getCount(fruit);
            if (count > 0) {
                result.add(fruit + "," + count);
            }
        }
        return result.toArray(new String[0]);
    }
}
