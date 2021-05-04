package main.service.impl;

import main.Exceptions.InvalidDataFormatException;
import main.model.Operation;
import main.model.dto.FruitRecordDto;
import main.service.interfaces.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String INVALID_DATA_FORMAT = "Invalid data format: ";
    private static final String EMPTY_LINE = "Empty line";
    private static final String DELIMITER = ",";
    private static final int operationTypeIndex = 0;
    private static final int quantityIndex = 2;
    private static final int nameIndex = 1;

    @Override
    public FruitRecordDto parse(String line) {
        Operation operation;
        String fruitName;
        int quantity;
        if (line.isEmpty()) {
            throw new InvalidDataFormatException(EMPTY_LINE);
        }
        String[] splitLine = line.split(DELIMITER);
        if (splitLine.length != 3) {
            throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
        }
        try {
            operation = Operation.valueOf(splitLine[operationTypeIndex].toUpperCase());
            fruitName = splitLine[nameIndex];
            quantity = Math.abs(Integer.parseInt(splitLine[quantityIndex]));
        } catch (IllegalArgumentException e) {
            throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
        }
        return new FruitRecordDto(operation, fruitName, quantity);
    }
}
