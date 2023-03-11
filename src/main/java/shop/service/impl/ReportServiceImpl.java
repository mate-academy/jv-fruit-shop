package shop.service.impl;

import java.util.LinkedList;
import java.util.List;
import shop.dao.FruitDao;
import shop.dao.FruitDaoImpl;
import shop.model.Fruit;
import shop.service.ReportService;

public class ReportServiceImpl implements ReportService {
    private static final String FIRST_LINE = "fruit,quantity";
    private final FruitDao fruitDao;

    public ReportServiceImpl() {
        fruitDao = new FruitDaoImpl();
    }

    public List<String> makeReport() {
        List<Fruit> listOfFruit = fruitDao.getAll();
        List<String> listReport = new LinkedList<>();
        listReport.add(FIRST_LINE);
        for (Fruit fruit : listOfFruit) {
            listReport.add(fruit.getName() + "," + fruit.getCount());
        }
        return listReport;
    }
}
