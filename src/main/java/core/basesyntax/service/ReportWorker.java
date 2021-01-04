package core.basesyntax.service;

import core.basesyntax.dao.Warehouse;
import core.basesyntax.db.DataBase;
import core.basesyntax.service.fileworker.InputOutputReport;
import java.time.LocalDate;
import java.util.Map;

public class ReportWorker implements ReportCheck {
    private final InputOutputReport inputOutputReport = new InputOutputReport();

    @Override
    public void readFromReport(String filName, Warehouse warehouse) {
        final char balance = 'b';
        final char supply = 's';
        final char purchase = 'p';
        final char returnFruit = 'r';
        final int operation = 0;
        final int typeFruit = 1;
        final int amount = 2;
        String[] file = inputOutputReport.readReport(filName).split(" ");
        for (String line : file) {
            String[] temp = line.split(",");
            switch (temp[operation].toLowerCase().charAt(0)) {
                case (balance):
                    warehouse.replace(temp[typeFruit], Integer.parseInt(temp[amount]));
                    break;
                case (supply):
                case (returnFruit):
                    warehouse.addItem(temp[typeFruit], Integer.parseInt(temp[amount]));
                    break;
                case (purchase):
                    if (!Validation.isValid(warehouse,
                            temp[typeFruit], Integer.parseInt(temp[amount]))) {
                        warehouse.getItemFrom(temp[typeFruit], Integer.parseInt(temp[amount]));
                    }
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void writeToReport(Warehouse warehouse) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        for (Map.Entry<String, Integer> fruit
                : DataBase.getListItems().entrySet()) {
            report.append(fruit.getKey()).append(",")
                    .append(fruit.getValue()).append(System.lineSeparator());
        }
        inputOutputReport.writeReport(report.toString(), LocalDate.now().toString());
    }
}
