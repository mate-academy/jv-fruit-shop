package core.basesyntax.service.implementations;

import core.basesyntax.service.ReportService;
import core.basesyntax.storage.Storage;
import java.util.List;
import java.util.stream.Collectors;

public class ReportServiceImpl implements ReportService {
    private static final String COMMA = ",";
    private static final String HEADER = "fruit,quantity";
    private static final int HEADER_LIST_INDEX = 0;

    @Override
    public List<String> generateReport() {
        List<String> reportData = Storage.getStorage().entrySet().stream()
                .map(entry -> entry.getKey() + COMMA + entry.getValue())
                .collect(Collectors.toList());
        reportData.add(HEADER_LIST_INDEX, HEADER);
        return reportData;
    }
}
