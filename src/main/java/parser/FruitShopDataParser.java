package parser;

import db.GenericDao;
import exceptions.InvalidDataException;
import java.util.List;
import strategy.OperationStrategy;

public class FruitShopDataParser implements Parser<List<String>> {
    private static final Integer TYPE_INDEX = 0;
    private static final Integer FRUIT_INDEX = 1;
    private static final Integer QUANTITY_INDEX = 2;
    private static final String SPLITERATOR = ",";
    private static final Integer CSV_DATA_PARTS = 3;
    private GenericDao fruitsDao;
    private OperationStrategy operationStrategy;

    public FruitShopDataParser(GenericDao fruitsDao, OperationStrategy operationStrategy) {
        this.fruitsDao = fruitsDao;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void parse(List<String> data) {
        String[] partsOfLine;
        for (int r = 1; r < data.size() - 1; r++) {
            partsOfLine = data.get(r).split(SPLITERATOR);
            if (partsOfLine.length != CSV_DATA_PARTS
                    || !(operationStrategy.isOperationExist(partsOfLine[TYPE_INDEX]))
                    || partsOfLine[QUANTITY_INDEX].charAt(0) == '-') {
                String dataInput = new StringBuilder(partsOfLine[TYPE_INDEX])
                        .append(partsOfLine[FRUIT_INDEX])
                        .append(partsOfLine[QUANTITY_INDEX])
                        .toString();
                throw new InvalidDataException("Invalid data: " + dataInput);
            }
            operationStrategy.getOperationStrategy(partsOfLine[TYPE_INDEX])
                    .changeBalance(partsOfLine[FRUIT_INDEX],
                            Integer.parseInt(partsOfLine[QUANTITY_INDEX]));
        }
    }
}
