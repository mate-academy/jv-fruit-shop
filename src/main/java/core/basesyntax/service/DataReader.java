package core.basesyntax.service;

import core.basesyntax.dto.Fruit;
import core.basesyntax.dto.Operation;
import core.basesyntax.exceptions.IllegalDataException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {
    private static final int TYPE_FIELD = 0;
    private static final int FRUIT_FIELD = 1;
    private static final int QUANTITY_FIELD = 2;
    private static final int SIZE = 3;

    private String fileName;

    public DataReader(String fileName) {
        this.fileName = fileName;
    }

    public static List<Operation> readFromFile(String fileName) throws IOException {
        List<Operation> listOfOperations = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String value = bufferedReader.readLine();
            while (value != null) {
                listOfOperations.add(createOperation(value));
                value = bufferedReader.readLine();
            }
        } catch (IOException | IllegalDataException e) {
            throw new IOException("Can't read file", e);
        }
        return listOfOperations;
    }

    private static Operation createOperation(String value) throws IllegalDataException {
        String[] operationFields = value.split(",");
        if (operationFields.length != SIZE) {
            throw new IllegalDataException("Can't read this data, it is illegal");
        }
        Operation.OperationType type;
        switch (operationFields[TYPE_FIELD]) {
            case "b" :
                type = Operation.OperationType.BALANCE;
                break;
            case "s" :
                type = Operation.OperationType.SUPPLY;
                break;
            case "p" :
                type = Operation.OperationType.PURCHASE;
                break;
            case "r" :
                type = Operation.OperationType.RETURN;
                break;
            default :
                throw new IllegalArgumentException("This operation type is not valid: "
                        + operationFields[TYPE_FIELD]);
        }
        int quantity = Integer.parseInt(operationFields[QUANTITY_FIELD]);
        Fruit fruit = new Fruit(operationFields[FRUIT_FIELD]);
        return new Operation(type, fruit, quantity);
    }
}
