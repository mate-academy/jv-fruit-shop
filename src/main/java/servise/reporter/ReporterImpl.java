package servise.reporter;

import db.Storage;
import model.Fruit;

public class ReporterImpl implements Reporter {
    @Override
    public String createReport() {
        StringBuilder report = new StringBuilder("fruit,quantity" + System.lineSeparator());
        for (Fruit fruitName : Storage.data.keySet()) {
            report.append(fruitName.getName())
                    .append(",")
                    .append(Storage.data.get(fruitName))
                    .append(System.lineSeparator());
        }
        return report.toString();
    }
}
