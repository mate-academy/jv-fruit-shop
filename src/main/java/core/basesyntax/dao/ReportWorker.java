package core.basesyntax.dao;

import core.basesyntax.fileworker.InputOutputReport;
import core.basesyntax.service.Validation;
import java.util.Map;

public class ReportWorker implements WarehouseDao {
    private InputOutputReport inputOutputReport = new InputOutputReport();

    @Override
    public void readFromReport(String filName, WarehouseImpl warehouse) {
        final char BALANCE = 'b';
        final char SUPPLY = 's';
        final char PURCHASE = 'p';
        final char RETURN = 'r';
        String[] file = inputOutputReport.readReport(filName).split(" ");
        for (String line : file) {
            String[] temp = line.split(",");
            switch (temp[0].toLowerCase().charAt(0)) {
                case (BALANCE):
                    warehouse.replace(temp[1], Integer.parseInt(temp[2]));
                    break;
                case (SUPPLY):
                case (RETURN):
                    warehouse.addFruit(temp[1], Integer.parseInt(temp[2]));
                    break;
                case (PURCHASE):
                    if (!Validation.isValid(warehouse, temp[1], Integer.parseInt(temp[2]))) {
                        throw new RuntimeException("wrong amount");
                    }
                    warehouse.getFruitFrom(temp[1], Integer.parseInt(temp[2]));
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    public void writeToReport(WarehouseImpl warehouse) {
        StringBuilder report = new StringBuilder();
        report.append("fruit,quantity").append(System.lineSeparator());
        Map<String, Integer> allFruits = warehouse.getListFruits();
        for (Map.Entry<String, Integer> fruit : allFruits.entrySet()) {
            report.append(fruit.getKey() + "," + fruit.getValue()).append(System.lineSeparator());
        }
        inputOutputReport.writeReport(report.toString());
    }
}
