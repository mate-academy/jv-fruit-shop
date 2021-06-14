package services;

import db.Storage;
import java.util.List;
import java.util.Map;
import services.actions.ActionHandler;

public class ReportImpl implements Report {
    private final ActionTypeStrategy actionTypeStrategy;

    public ReportImpl(ActionTypeStrategy actionTypeStrategy) {
        this.actionTypeStrategy = actionTypeStrategy;
    }

    @Override
    public String createReport(List<String> records) {
        StringBuilder report = new StringBuilder();
        RecordValidation recordValidation = new RecordValidation();
        report.append("fruit,quantity\n");

        for (String record: records) {
            String[] recordParts = record.split(",");

            if (recordValidation.test(recordParts)) {
                String fruitName = recordParts[1];
                String type = recordParts[0];
                int quantity = Integer.parseInt(recordParts[2]);
                ActionHandler actionHandler = actionTypeStrategy.get(type);
                actionHandler.getResultOfAction(fruitName, quantity);
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
