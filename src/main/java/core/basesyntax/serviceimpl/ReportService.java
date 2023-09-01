package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import java.util.Map;

public class ReportService {

    public String createReport() {
        String report = "fruit," + "quantity";
        for (Map.Entry<String, Integer> entry :
                Storage.DB.entrySet()) {
            report += System.lineSeparator() + entry.getKey() + "," + entry.getValue();
        }
        return report;
    }
}

