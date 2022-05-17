package mate.academy.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import mate.academy.model.FruitTransaction;
import mate.academy.service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int STRING_NUMBER_FOR_START_PARSING = 1;
    private static final int OPERAT_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int FRUIT_QUANTITY_INDEX = 2;
    private static final String REGEX_FOR_PARSING = ",";

    @Override
    public List<FruitTransaction> parse(List<String> stringsFromFile) {
        return stringsFromFile.subList(STRING_NUMBER_FOR_START_PARSING, stringsFromFile.size())
                .stream()
                .map(s -> s.split(REGEX_FOR_PARSING))
                .map(s -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setOperation(FruitTransaction.Operation.get(s[OPERAT_INDEX]));
                    fruitTransaction.setFruit(s[FRUIT_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(s[FRUIT_QUANTITY_INDEX]));
                    return fruitTransaction;
                }
                )
                .collect(Collectors.toList());
    }
}
