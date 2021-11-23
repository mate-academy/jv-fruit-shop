package service.impl;

import dao.FruitDao;
import java.util.Map;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final FruitDao dao;

    public ReportServiceImpl(FruitDao dao) {
        this.dao = dao;
    }

    @Override
    public String createReport() {
        StringBuilder builder = new StringBuilder();
        builder.append("fruit,quantity").append("\n");
        for (Map.Entry<Fruit, Integer> set : dao.getAll().entrySet()) {
            builder.append(set.getKey().getName())
                    .append(",").append(set.getValue())
                    .append("\n");
        }
        return builder.toString();
    }
}
