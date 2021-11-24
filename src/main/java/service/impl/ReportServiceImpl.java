package service.impl;

import dao.FruitDao;
import dao.FruitDaoImpl;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final FruitDao fruitDao;

    public ReportServiceImpl() {
        fruitDao = new FruitDaoImpl();
    }

    public List<String> createReport() {
        List<Fruit> listOfFruit = fruitDao.getAll();
        List<String> listReport = new ArrayList<>();
        listReport.add("fruit,quantity");
        for (Fruit fruit : listOfFruit) {
            listReport.add(fruit.getName() + "," + fruit.getCount());
        }
        return listReport;
    }
}
