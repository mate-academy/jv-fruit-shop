package core.basesyntax.handlers.impl;

import core.basesyntax.data.Storage;
import core.basesyntax.handlers.ReportGenerator;
import java.util.ArrayList;
import java.util.List;

public class ReportGeneratorImpl implements ReportGenerator {
    public static final String COLUM_VALUE = "fruit,quantity";
    public static final String SPLIT = ",";

    @Override
    public List<String> getReport() {
        List<String> returnList = new ArrayList<>();
        returnList.add(COLUM_VALUE);
        returnList.addAll(
                Storage.getAssortment().entrySet().stream()
                        .map(e -> e.getKey() + SPLIT + e.getValue())
                        .toList()
        );
        return returnList;
    }
}
