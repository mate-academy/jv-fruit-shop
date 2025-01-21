package core.basesyntax.dao;

import core.basesyntax.models.Product;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String HEADER = "type,fruit,quantity";
    private static final String SPLITTER = ",";

    public List<Product> convertToTransaction(List<String> productsInString) {
        List<Product> products = new ArrayList<>();
        for (String product : productsInString) {
            String[] splitString = product.split(SPLITTER);
            if (product.equals(HEADER)) {
                continue;
            }
            Product.TypeOfActivity typeOfActivity = Arrays.stream(Product.TypeOfActivity.values())
                    .filter(type -> type.getCode().equals(splitString[0]))
                    .findFirst()
                    .orElseThrow(IllegalAccessError::new);

            products.add(Product.of(
                    typeOfActivity,
                    splitString[1],
                    Integer.parseInt(splitString[2]))
            );

        }
        return products;
    }
}
