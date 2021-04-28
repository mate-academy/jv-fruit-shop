package service;

import exception.IncorrectInputValueException;
import java.util.ArrayList;
import java.util.List;
import model.Fruit;
import model.OperationType;
import service.interfaces.FruitRecordParser;

public class FruitRecordParserImpl implements FruitRecordParser {
    private static final String SEPARATING_ELEMENT = ",";
    private static final int INDEX_OF_OPERATION_TYPE = 0;
    private static final int INDEX_OF_FRUIT_TYPE = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private static final String MATCHE_FOR_INTEGER = "[0-9]+";
    private static final String MASSAGE_FOR_EXCEPTION = "Incorrect input value";
    private OperationType type;
    private Fruit.Type fruitType;
    private Integer quantity;

    public FruitRecordParserImpl() {
    }

    public FruitRecordParserImpl(OperationType type, Fruit.Type fruitType, Integer quantity) {
        this.type = type;
        this.fruitType = fruitType;
        this.quantity = quantity;
    }

    public OperationType getType() {
        return type;
    }

    public Fruit.Type getFruitType() {
        return fruitType;
    }

    public Integer getQuantity() {
        return quantity;
    }

    @Override
    public List<FruitRecordParserImpl> parseLines(List<String> fileContent) {
        List<FruitRecordParserImpl> parsedLines = new ArrayList<>();
        for (int i = 1; i < fileContent.size(); i++) {
            String[] information = fileContent.get(i).split(SEPARATING_ELEMENT);
            OperationType operationType = new OperationTypeServiceImpl()
                    .getOperationType(information[INDEX_OF_OPERATION_TYPE]);
            Fruit.Type fruitType = new FruitTypeServiceImpl()
                    .getFruitType(information[INDEX_OF_FRUIT_TYPE]);
            if (!information[INDEX_OF_QUANTITY].matches(MATCHE_FOR_INTEGER)) {
                throw new IncorrectInputValueException(MASSAGE_FOR_EXCEPTION);
            }
            int quantity = Integer.parseInt(information[INDEX_OF_QUANTITY]);
            if (quantity < 0) {
                throw new IncorrectInputValueException(MASSAGE_FOR_EXCEPTION);
            }
            FruitRecordParserImpl fruitRecordParser = new FruitRecordParserImpl(operationType,
                    fruitType, quantity);
            parsedLines.add(fruitRecordParser);
        }
        return parsedLines;
    }
}
