package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportWriterService;
import java.util.ArrayList;
import java.util.List;

public class ReportWriterImpl implements ReportWriterService {
    private List<String[]> report = new ArrayList<>();

    public List<String[]> getReport() {
        writeHead();
        writeBody(Storage.getAll());
        return report;
    }

    public void writeHead() {
        report.add(new String[]{"fruit", "quantity"});
    }

    public void writeBody(List<String[]> fruits) {
        for (String[] line : fruits) {
            report.add(line);
        }
    }
}
