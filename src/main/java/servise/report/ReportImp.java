package servise.report;

import db.Storage;
import model.Fruit;

public class ReportImp implements Report {
    @Override
    public String report() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Fruit fruitName : Storage.map.keySet()) {
            report.append(fruitName.getName())
                    .append(",")
                    .append(Storage.map.get(fruitName))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
