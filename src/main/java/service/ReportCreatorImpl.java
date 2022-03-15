package service;

import java.util.List;
import model.Fruit;

public class ReportCreatorImpl implements ReportCreator {
    private static final String HEADER = "fruit,quantity";

    @Override
    public String createReport(List<Fruit> fruits) {

        StringBuilder builder = new StringBuilder();
        builder.append(HEADER)
                .append(System.lineSeparator());
        for (Fruit fruit : fruits) {
            builder.append(fruit.getFruit())
                    .append(",")
                    .append(fruit.getQuantity())
                    .append(System.lineSeparator());
        }
        return builder.toString();
    }
}

