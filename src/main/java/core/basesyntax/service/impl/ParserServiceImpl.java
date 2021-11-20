package core.basesyntax.service.impl;

import core.basesyntax.exceptions.InvalidDataFormatException;
import core.basesyntax.model.Operation;
import core.basesyntax.model.dto.FruitRecordDto;
import core.basesyntax.service.interfaces.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String INVALID_DATA_FORMAT = "Invalid data format: ";
    private static final String EMPTY_LINE = "Empty line";
    private static final String DELIMITER = ",";
    private static final int operationTypeIndex = 0;
    private static final int quantityIndex = 2;
    private static final int nameIndex = 1;
    private static final int MAX_VALUES_NUMBER = 3;

    @Override
    public FruitRecordDto parse(String line) {
        if (line.isEmpty()) {
            throw new InvalidDataFormatException(EMPTY_LINE);
        }
        String[] splitLine = line.split(DELIMITER);
        if (splitLine.length != MAX_VALUES_NUMBER) {
            throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
        }
        Operation operation;
        String fruitName;
        int quantity;
        try {
            switch (splitLine[operationTypeIndex]) {
                case "b":
                    operation = Operation.BALANCE;
                    break;
                case "s":
                    operation = Operation.SUPPLY;
                    break;
                case "p":
                    operation = Operation.PURCHASE;
                    break;
                case "r":
                    operation = Operation.RETURN;
                    break;
                default:
                    operation = Operation.valueOf(splitLine[operationTypeIndex]);
            }
            fruitName = splitLine[nameIndex];
            quantity = Math.abs(Integer.parseInt(splitLine[quantityIndex]));
        } catch (IllegalArgumentException e) {
            throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
        }
        return new FruitRecordDto(operation, fruitName, quantity);
    }
}
