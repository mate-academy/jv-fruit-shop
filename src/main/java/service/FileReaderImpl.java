package service;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.FruitTransactionStorage;

public class FileReaderImpl implements FileReader {
    private static final String SPLIT_REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransactionStorage read(String inputFileName) {
        List<FruitTransaction> transactions = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(inputFileName))) {
            reader.readLine();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(SPLIT_REGEX);

                if (parts.length != 3) {
                    throw new ValidationDataException(
                            "Invalid input format in file: " + inputFileName);
                }

                FruitTransaction transaction = new FruitTransaction();

                try {
                    transaction.setOperation(
                            FruitTransaction.Operation.fromCode(
                                    parts[OPERATION_INDEX].trim()));
                } catch (IllegalArgumentException e) {
                    throw new ValidationDataException(
                            "Invalid operation code in file: " + inputFileName);
                }

                transaction.setFruit(parts[FRUIT_INDEX]);

                try {
                    transaction.setQuantity(Integer.parseInt(
                            parts[QUANTITY_INDEX].trim()));
                } catch (NumberFormatException e) {
                    throw new ValidationDataException(
                            "Invalid quantity format in file: " + inputFileName);
                }

                transactions.add(transaction);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read from file: " + inputFileName);
        }

        return new FruitTransactionStorage(transactions);
    }
}
