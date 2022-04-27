package service.impl;

import db.Storage;
import model.Fruit;
import service.ReportService;
import java.util.Map;

public class ReportServiceImpl implements ReportService {

    @Override
    public String report() {
        StringBuilder stringBuilder = new StringBuilder("fruit,quantity\n");
        for (Map.Entry<Fruit, Integer> entry : Storage.dataBase.entrySet()) {
            stringBuilder.append(entry.getKey().getFruit())
                    .append(",")
                    .append(entry.getValue().intValue())
                    .append(System.lineSeparator());
        }
        return stringBuilder.toString();
    }
}
