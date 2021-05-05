package shopservice;

import fruitsassortment.Fruit;
import java.util.Map;
import shopdao.FruitDao;

public class ReportServiceImpl implements ReportService {
    private static final String SEPARATOR = ",";
    private final FruitDao fruitDao;

    public ReportServiceImpl(FruitDao fruitDao) {
        this.fruitDao = fruitDao;
    }

    @Override
    public String getReport() {
        StringBuilder report = new StringBuilder().append("fruit,amount");
        Map<Fruit, Integer> products = fruitDao.getAll();
        for (Map.Entry<Fruit, Integer> productsEntry : products.entrySet()) {
            report.append(System.lineSeparator())
                    .append(productsEntry.getKey().getName())
                    .append(SEPARATOR)
                    .append(productsEntry.getValue());
        }
        return report.toString();
    }
}
