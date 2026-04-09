package service.impl;

import dao.FruitDao;
import db.FruitStorage;
import service.ReportGenerator;

public class ReportGeneratorImpl implements ReportGenerator {
    public ReportGeneratorImpl(FruitDao fruitDao) {
    }

    @Override
    public String getReport() {
        StringBuilder sb = new StringBuilder("fruit,quantity\n");
        FruitStorage.fruits.forEach((f, q) -> sb.append(f).append(",").append(q).append("\n"));
        return sb.toString().trim();
    }
}
