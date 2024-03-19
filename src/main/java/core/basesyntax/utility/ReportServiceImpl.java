package core.basesyntax.utility;

import core.basesyntax.db.Storage;
import core.basesyntax.utility.service.ReportService;
import java.util.ArrayList;
import java.util.List;

public class ReportServiceImpl implements ReportService {
    @Override
    public List<Pair<String, Integer>> createReport() {
        List<Pair<String, Integer>> report = new ArrayList<>();

        for (var element : Storage.fruitStorage.entrySet()) {
            Pair<String, Integer> temporary = new Pair<>(element.getKey(), element.getValue());
            report.add(temporary);
        }
        return report;
    }
}
