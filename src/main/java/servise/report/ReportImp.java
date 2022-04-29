package servise.report;

import db.Storage;

import java.util.List;

public class ReportImp implements Report {
    @Override
    public String report() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());

        for (String fruitName : Storage.map.keySet()) {
            report.append(fruitName)
                    .append(",")
                    .append(Storage.map.get(fruitName))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
