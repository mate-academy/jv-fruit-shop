package service.implementation;

import java.util.List;
import java.util.stream.Collectors;
import model.FruitTransaction;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_TYPE_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String PARSING_SYMBOL = ",";

    @Override
    public List<FruitTransaction> parse(List<String> stringsFromFile) {
        return stringsFromFile.subList(1, stringsFromFile.size())
                .stream()
                .map(s -> s.split(PARSING_SYMBOL))
                .map(strings -> {
                    FruitTransaction fruitTransaction = new FruitTransaction();
                    fruitTransaction.setTransaction(FruitTransaction.TransactionType
                            .get(strings[TRANSACTION_INDEX]));
                    fruitTransaction.setFruit(strings[FRUIT_TYPE_INDEX]);
                    fruitTransaction.setQuantity(Integer.parseInt(strings[QUANTITY_INDEX]));
                    return fruitTransaction;
                })
                .collect(Collectors.toList());
    }
}
