package files;

import model.FruitTransaction;
import model.Operation;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import static storages.TransactionStorage.transactionList;

public class CsvReader implements Reader {
    private static final String CSV_DATA_SEPARATOR = ",";
    private static final int OPERATION_ARRAY_INDEX = 0;
    private static final int FRUIT_ARRAY_INDEX = 1;
    private static final int QUANTITY_ARRAY_INDEX = 2;
    private static final String CANT_READ_DATA_FROM_FILE_MESSAGE = "Can't read data from file: ";

    @Override
    public void readFromFile(String path) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String dataLine = reader.readLine();
            while (dataLine != null) {
                transactionList.add(parseDataToFruitTransaction(dataLine));
                dataLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_DATA_FROM_FILE_MESSAGE + path);
        }
    }

    private FruitTransaction parseDataToFruitTransaction(String dataLine) {
        String[] data = dataLine.split(CSV_DATA_SEPARATOR);
        String operationType = data[OPERATION_ARRAY_INDEX];
        String fruit = data[FRUIT_ARRAY_INDEX];
        int quantity = Integer.parseInt(data[QUANTITY_ARRAY_INDEX]);
        Operation operation = Operation.fromString(operationType);
        return new FruitTransaction(operation, fruit, quantity);
    }
}
