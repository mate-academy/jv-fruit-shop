package core.basesyntax.service;

import core.basesyntax.dp.Storage;
import core.basesyntax.service.impl.ReportService;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {

    @Override
    public String getReport() {
        return Storage.getStorage().entrySet().stream()
                .map(totalFruits -> totalFruits.getKey() + "," + totalFruits.getValue()
                        + System.lineSeparator())
                .collect(Collectors.joining());
    }
}
