package service.implementations;

import db.Storage;
import java.util.Map;
import model.Fruit;
import service.inerfaces.ReportMaker;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public String formReport() {
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<Fruit, Integer> entry : Storage.storage.entrySet()) {
            builder.append(entry.getKey().getName()).append(",")
                    .append(String.valueOf(entry.getValue()))
                    .append(System.lineSeparator()).toString();
        }
        return builder.toString();
    }
}
