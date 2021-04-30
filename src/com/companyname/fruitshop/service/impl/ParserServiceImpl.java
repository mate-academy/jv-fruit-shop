package com.companyname.fruitshop.service.impl;

import com.companyname.fruitshop.model.Operation;
import com.companyname.fruitshop.model.dto.FruitRecordDto;
import com.companyname.fruitshop.service.interfaces.ParserService;

public class ParserServiceImpl implements ParserService {
    private static final String EMPTY_LINE = "Empty line";
    private static final String QUANTITY = "quantity";
    private static final String OPERATION_TYPE = "type";
    private static final String PRODUCT = "fruit";
    private static final String DELIMITER = ",";
    private static final String INVALID_DATA_FORMAT = "Invalid data format: ";
    private static int operationTypeIndex;
    private static int quantityIndex;
    private static int nameIndex;

    @Override
    public FruitRecordDto parse(String line) {
        if (line.isEmpty()) {
            throw new InvalidDataFormatException(EMPTY_LINE);
        }
        if (isValidFirstLine(line)) {
            String[] splitLine = line.split(DELIMITER);
            try {
                for (int i = 0; i < splitLine.length; i++) {
                    operationTypeIndex = OPERATION_TYPE.equals(splitLine[i]) ? i : operationTypeIndex;
                    quantityIndex = QUANTITY.equals(splitLine[i]) ? i : quantityIndex;
                    nameIndex = PRODUCT.equals(splitLine[i]) ? i : nameIndex;
                }
            } catch (Exception e) {
                throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
            }
            return new FruitRecordDto(Operation.b, "", 0);
        }
        Operation operation;
        String fruitName;
        int quantity;
        String[] splitLine = line.split(DELIMITER);
        try {
            operation = Operation.valueOf(splitLine[operationTypeIndex]);
            fruitName = splitLine[nameIndex];
            quantity = Integer.parseInt(splitLine[quantityIndex]);
        } catch (Exception e) {
            throw new InvalidDataFormatException(INVALID_DATA_FORMAT + line);
        }
        return new FruitRecordDto(operation, fruitName, quantity);
    }

    private boolean isValidFirstLine(String line) {
        if (line.contains(QUANTITY)
                || line.contains(OPERATION_TYPE)
                || line.contains(PRODUCT)) {
            return line.contains(QUANTITY) && line.contains(OPERATION_TYPE) && line.contains(PRODUCT);
        }
        return false;
    }
}
