package files;

import model.FruitTransaction;
import model.Operation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public class CsvReader implements Reader{
    private static final String CSV_DATA_SEPARATOR = ",";
    public static final int OPERATION_ARRAY_INDEX = 0;
    public static final int FRUIT_ARRAY_INDEX = 1;
    public static final int QUANTITY_ARRAY_INDEX = 2;
    public static final String CANT_READ_DATA_FROM_FILE_MESSAGE = "Can't read data from file: ";
    private final List<FruitTransaction> transactionList;

    public CsvReader(List<FruitTransaction> transactionList) {
        this.transactionList = transactionList;
    }
    @Override
    public void readFromFile(Path path) {
        try(BufferedReader reader = new BufferedReader(new FileReader(path.toFile()))) {
            String dataLine = reader.readLine();
            while (dataLine != null) {
                String[] data = dataLine.split(CSV_DATA_SEPARATOR);
                String operationType = data[OPERATION_ARRAY_INDEX];
                String fruit = data[FRUIT_ARRAY_INDEX];
                int quantity = Integer.parseInt(data[QUANTITY_ARRAY_INDEX]);
                Operation operation = Operation.fromString(operationType);
                transactionList.add(new FruitTransaction(operation, fruit, quantity));
                dataLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(CANT_READ_DATA_FROM_FILE_MESSAGE + path.getFileName() );
        }
    }
}
