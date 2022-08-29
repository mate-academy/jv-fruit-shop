package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.Fruits;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String SEPARATOR = ",";
    private static final int TYPE_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int SKIP_TITLE_INDEX = 1;

    @Override
    public List<Fruits> parse(List<String> lines) {
        List<Fruits> fruitTransactions = new ArrayList<>();
        lines.stream()
                .skip(SKIP_TITLE_INDEX)
                .map(i -> i.split(SEPARATOR))
                .forEach(rows -> fruitTransactions.add(new Fruits(
                        Fruits.getOperationType(rows[TYPE_INDEX]), rows[FRUIT_INDEX],
                        Integer.parseInt(rows[QUANTITY_INDEX]))));
        return fruitTransactions;
    }
}
