package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.service.ReportGenerator;
import java.util.Map;
import java.util.Stack;

public class ReportGeneratorImpl implements ReportGenerator {
    private static final String HEAD_LINE = "fruit,quantity" + System.lineSeparator();

    @Override
    public String getReport() {
        Stack<String> stack = new Stack<>();
        stack.push(HEAD_LINE);
        for (Map.Entry<String, Integer> entry : Storage.getStorage().entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity can't be less than 0");
            }
            stack.push(entry.getKey() + "," + entry.getValue() + System.lineSeparator());
        }
        StringBuilder builder = new StringBuilder();
        while (!stack.isEmpty()) {
            builder.append(stack.pop());
        }
        return builder.toString();
    }
}
