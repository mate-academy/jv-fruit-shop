package core.basesyntax.service;

import core.basesyntax.ReportGenerator;
import core.basesyntax.Storage;
import java.util.Map;
import java.util.Stack;

public class ReportGeneratorImpl implements ReportGenerator {
    @Override
    public String getReport(Storage storage) {
        Stack<String> reportStack = new Stack<>();
        reportStack.push("fruit,quantity" + System.lineSeparator());

        for (Map.Entry<String, Integer> entry : storage.getAllFruits().entrySet()) {
            String reportLine = entry.getKey() + "," + entry.getValue() + System.lineSeparator();
            reportStack.push(reportLine);
        }

        StringBuilder report = new StringBuilder();
        while (!reportStack.isEmpty()) {
            report.append(reportStack.pop());
        }

        return report.toString();
    }
}
