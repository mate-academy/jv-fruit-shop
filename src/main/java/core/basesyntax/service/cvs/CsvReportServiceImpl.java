package core.basesyntax.service.cvs;

import core.basesyntax.db.Storage;
import java.util.stream.Collectors;

public class CsvReportServiceImpl implements CsvReportService {

    @Override
    public String getReport() {
        return Storage.fruits.entrySet().stream()
                .map(z -> z.getKey() + "," + z.getValue().getQuantity())
                .collect(Collectors.joining(System.lineSeparator(), "fruit,quantity\n", ""));
    }
}
