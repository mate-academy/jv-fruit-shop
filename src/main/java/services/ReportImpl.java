package services;

import db.Storage;
import java.util.List;
import java.util.Map;
import services.actions.ActionHandler;

public class ReportImpl implements Report {
    private final ActionTypeStrategy actionTypeStrategy;
    private final RecordValidation recordValidation = new RecordValidation();

    public ReportImpl(ActionTypeStrategy actionTypeStrategy) {
        this.actionTypeStrategy = actionTypeStrategy;
    }

    @Override
    public String createReport(List<String> records) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity\n");

        for (String record: records) {
            String[] recordParts = record.split(",");

            if (recordValidation.test(recordParts)) {
                String fruitName = recordParts[1];
                String type = recordParts[0];
                int quantity = Integer.parseInt(recordParts[2]);
                ActionHandler actionHandler = actionTypeStrategy.get(type);
                Map<String, Integer> storage = actionHandler.getResultOfAction(fruitName, quantity);
                System.out.println(storage);
            }
        }

        for (Map.Entry<String,Integer> pair: Storage.fruits.entrySet()) {
            report.append(pair.getKey())
                    .append(",")
                    .append(pair.getValue())
                    .append("\n");
        }

        return report.toString();
    }
}
