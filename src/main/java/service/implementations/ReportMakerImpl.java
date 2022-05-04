package service.implementations;

import dao.FruitsDao;
import dao.FruitsDaoImpl;
import java.util.Map;
import model.Fruit;
import service.inerfaces.ReportMaker;

public class ReportMakerImpl implements ReportMaker {
    @Override
    public String formReport() {
        StringBuilder builder = new StringBuilder();
        FruitsDao fruitsDao = new FruitsDaoImpl();
        for (Map.Entry<Fruit, Integer> entry : fruitsDao.getAll().entrySet()) {
            builder.append(entry.getKey().getName()).append(",")
                    .append(String.valueOf(entry.getValue()))
                    .append(System.lineSeparator()).toString();
        }
        return builder.toString();
    }
}
