package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class ReportWriter {
    private List<String[]> report = new ArrayList<>();

    public List<String[]> getReport() {
        return report;
    }

    public void writeHead() {
        report.add(new String[]{"fruit", "quantity"});
    }

    public void writeLine(String fruit, Integer amount) {
        report.add(new String[]{fruit, String.valueOf(amount)});
    }
}
