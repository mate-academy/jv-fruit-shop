package parser;

import core.basesyntax.Checker;
import db.GenericDao;
import exceptions.InvalidDataException;
import java.util.List;
import strategy.OperationTypes;

public class FruitShopDataParser implements Parser<List<String>> {
    private static final Integer TYPE_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private static final Integer CSV_DATA_PARTS = 3;
    private GenericDao fruitsDao;

    public FruitShopDataParser(GenericDao fruitsDao) {
        this.fruitsDao = fruitsDao;
    }

    @Override
    public void parse(List<String> data) {
        String[] partsOfLine;
        OperationTypes operationTypes = new OperationTypes(fruitsDao);
        for (int r = 1; r < data.size() - 1; r++) {
            partsOfLine = data.get(r).split(SPLITERATOR);
            if (partsOfLine.length != CSV_DATA_PARTS
                    || !(operationTypes.isOperationExist(partsOfLine[TYPE_INDEX]))
                    || partsOfLine[QUANTITY_INDEX].charAt(0) == '-')) {
                String dataInput = new StringBuilder(partsOfLine[TYPE_INDEX])
                        .append(partsOfLine[FRUIT_INDEX])
                        .append(partsOfLine[QUANTITY_INDEX])
                        .toString();
                throw new InvalidDataException("Invalid data: " + dataInput);
            }
            operationTypes.getOperationStrategy(partsOfLine[TYPE_INDEX])
                    .changeBalance(partsOfLine[FRUIT_INDEX],
                            Integer.parseInt(partsOfLine[QUANTITY_INDEX]));
        }
    }
}
