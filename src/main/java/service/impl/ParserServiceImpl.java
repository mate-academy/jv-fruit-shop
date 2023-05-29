package service.impl;

import model.Fruit;
import service.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String COMA = ",";
    private static final int FIRST_POSITION_IN_LINE = 0;
    private static final int SECOND_POSITION_IN_LINE = 1;
    private static final int THIRD_POSITION_IN_LINE = 2;

    @Override
    public Fruit getFruitFromCsvRow(String line) {
        String [] fields = line.split(COMA);
        Fruit fruit = new Fruit();
        fruit.setOperation(Fruit.Operation.getByCode(fields[FIRST_POSITION_IN_LINE]));
        fruit.setFruit(fields[SECOND_POSITION_IN_LINE]);
        fruit.setQuantity(Integer.parseInt(fields[THIRD_POSITION_IN_LINE]));
        return fruit;
    }
}
