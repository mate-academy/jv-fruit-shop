package core.basesyntax.service.impl;

import core.basesyntax.model.Grid;
import core.basesyntax.service.GridGeneratorService;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FruitGridGeneratorService implements GridGeneratorService<Map<String, Integer>> {
    public static final String[] DEFAULT_TITLES = {"fruit", "quantity"};
    private static final int FRUIT_INDEX = 0;
    private static final int QUANTITY_INDEX = 1;
    private static final int ROW_SIZE = 2;

    @Override
    public Grid grid(Map<String, Integer> value) {
        List<String[]> rows = value.entrySet()
                .stream()
                .map(e -> createRow(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
        return new Grid(DEFAULT_TITLES, rows);
    }

    private String[] createRow(String fruit, int amount) {
        String[] row = new String[ROW_SIZE];
        row[FRUIT_INDEX] = fruit;
        row[QUANTITY_INDEX] = Integer.toString(amount);
        return row;
    }
}
