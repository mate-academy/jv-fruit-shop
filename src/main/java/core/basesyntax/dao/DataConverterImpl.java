package core.basesyntax.dao;

import core.basesyntax.models.Fruit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String HEADER = "type,fruit,quantity";
    private static final String SPLITTER = ",";

    public List<Fruit> convertToTransaction(List<String> productsInString) {
        List<Fruit> fruits = new ArrayList<>();
        for (String product : productsInString) {
            String[] splitString = product.split(SPLITTER);
            if (product.equals(HEADER)) {
                continue;
            }
            Fruit.TypeOfActivity typeOfActivity = Arrays.stream(Fruit.TypeOfActivity.values())
                    .filter(type -> type.getCode().equals(splitString[0]))
                    .findFirst()
                    .orElseThrow(() -> new IllegalArgumentException("Can`t find type of activity"));

            fruits.add(Fruit.of(
                    typeOfActivity,
                    splitString[1],
                    Integer.parseInt(splitString[2]))
            );

        }
        return fruits;
    }
}
