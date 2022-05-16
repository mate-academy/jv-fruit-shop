package mate.academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.Fruit;
import mate.academy.service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int STRING_NUMBER_FOR_START_PARSING = 1;
    private static final int OPERATION_INDEX_NUMBER = 0;
    private static final int FRUIT_INDEX_NUMBER = 1;
    private static final int FRUIT_QUANTITY_INDEX_NUMBER = 2;
    private static final String REGEX_FOR_PARSING = ",";
    private static final String OPERATION_BALANCE = "b";
    private static final String OPERATION_PURCHASE = "p";
    private static final String OPERATION_SUPPLY = "s";
    private static final String OPERATION_RETURN = "r";

    @Override
    public List<Fruit> parseString(List<String> stringsFromFile) {
        return stringsFromFile.subList(STRING_NUMBER_FOR_START_PARSING, stringsFromFile.size())
                .stream()
                .map(s -> s.split(REGEX_FOR_PARSING))
                .map(s -> {
                    Fruit fruit = new Fruit();
                    fruit.setOperation(s[OPERATION_INDEX_NUMBER].equals(OPERATION_BALANCE)
                            ? Fruit.Operation.BALANCE
                            : s[OPERATION_INDEX_NUMBER].equals(OPERATION_PURCHASE)
                            ? Fruit.Operation.PURCHASE
                            : s[OPERATION_INDEX_NUMBER].equals(OPERATION_SUPPLY)
                            ? Fruit.Operation.SUPPLY
                            : Fruit.Operation.RETURN);
                    fruit.setFruit(s[FRUIT_INDEX_NUMBER]);
                    fruit.setQuantity(Integer.parseInt(s[FRUIT_QUANTITY_INDEX_NUMBER]));
                    return fruit;
                }
                )
                .collect(Collectors.toList());
    }
}
