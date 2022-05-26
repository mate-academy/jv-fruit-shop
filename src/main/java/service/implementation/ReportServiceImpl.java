package service.implementation;

import java.util.List;
import model.Fruit;
import service.FruitService;
import service.ReportService;

public class ReportServiceImpl implements ReportService {
    private final FruitService fruitService;

    public ReportServiceImpl(FruitService fruitService) {
        this.fruitService = fruitService;
    }

    @Override
    public String getReport() {
        List<Fruit> fruits = fruitService.getAll();
        StringBuilder builder = new StringBuilder("fruit, quantity");
        for (Fruit fruit : fruits) {
            builder.append(System.lineSeparator())
                    .append(fruit.getName())
                    .append(",")
                    .append(fruit.getAmount());
        }
        return builder.toString();
    }
}
