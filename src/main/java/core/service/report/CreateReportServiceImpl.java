package core.service.report;

import core.db.Storage;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateReportServiceImpl implements CreateReportService {
    private static final String TITLE = "fruit,quantity";

    @Override
    public List<String> createReport() {
        List<String> result = new ArrayList<>();
        result.add(TITLE);
        for (Map.Entry<String, Integer> entry : Storage.stockStorage.entrySet()) {
            result.add(entry.getKey() + "," + entry.getValue());
        }
        return result;
    }
}
