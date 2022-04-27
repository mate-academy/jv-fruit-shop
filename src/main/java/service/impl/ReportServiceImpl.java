package service.impl;

import db.Storage;
import java.util.Map;
import model.Fruit;
import service.ReportService;

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
