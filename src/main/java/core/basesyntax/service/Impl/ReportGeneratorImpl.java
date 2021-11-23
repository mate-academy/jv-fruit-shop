package core.basesyntax.service.Impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> generate(Storage storage) {
        List<String > report = new ArrayList<>();
        report.add("fruit,quantity");
        Set<String> fruitNames = storage.getProductNames();
        for (String fruitName : fruitNames) {
            report.add(fruitName + "," + storage.getAmount(fruitName));
        }
        return report;
    }
}
