package core.basesyntax.db;

import core.basesyntax.db.service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {
    @Override
    public Map<String, Integer> generate(Map<String, Integer> report) {
        return Storage.storage;
    }
}
