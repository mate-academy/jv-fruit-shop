package core.basesyntax.service.accountingreport;

import java.util.Map;

public class AccountingImpl implements Accounting {
    @Override
    public String makeReport(Map<String, Integer> fruitKindsAndQuantity) {
        StringBuilder builder = new StringBuilder();
        builder.append(HEADER).append(System.lineSeparator());
        for (Map.Entry<String, Integer> entry : fruitKindsAndQuantity.entrySet()) {
            if (entry.getValue() < 0) {
                throw new RuntimeException("Quantity : " + entry.getKey()
                        + " can't be less than 0");
            }
            builder.append(entry.getKey()).append(COMMA).append(entry.getValue())
                    .append(System.lineSeparator());
        }
        String report = builder.toString();
        printReportToConsole(report);
        return report;
    }

    private void printReportToConsole(String report) {
        System.out.println(report);
    }
}
