package service.implementation;

import exception.InvalidDataFormatException;
import java.util.Arrays;
import model.Fruit;
import model.FruitTransactionDto;
import model.Operation;
import service.DataParser;

public class CsvDataParser implements DataParser {
    public static final int OPERATION = 0;
    public static final int FRUIT_NAME = 1;
    public static final int FRUITS_AMOUNT = 2;
    public static final String COMMA = ",";

    @Override
    public FruitTransactionDto parse(String line) throws InvalidDataFormatException {
        String[] parsedLine = line.split(COMMA);
        try {
            return new FruitTransactionDto(Operation.fromString(parsedLine[OPERATION]),
                    new Fruit(parsedLine[FRUIT_NAME].toLowerCase()),
                    Integer.parseInt(parsedLine[FRUITS_AMOUNT]));
        } catch (NumberFormatException nfe) {
            throw new InvalidDataFormatException("Input data has invalid format: "
                    + Arrays.toString(parsedLine) + "\n"
                    + "should be ['o' - operation, 'fruit', '3'- amount]");
        }
    }
}
