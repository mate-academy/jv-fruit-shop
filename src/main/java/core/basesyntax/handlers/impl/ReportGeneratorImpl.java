package core.basesyntax.handlers.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.handlers.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public List<String> getReport() {
        List<String> returnList = new ArrayList<>();
        returnList.add("fruit,quantity");
        returnList.addAll(
                Storage.getAssortment().entrySet().stream()
                        .map(e -> e.getKey() + "," + e.getValue())
                        .toList()
        );
        return returnList;
    }
}
