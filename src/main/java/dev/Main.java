package dev;

import dev.input.FileReaderImpl;
import dev.input.Reader;
import dev.transaction.DataConverter;
import dev.transaction.DataConverterImpl;
import dev.transaction.FruitTransaction;
import java.util.List;

public class Main {
    private static final String FILE_READ_SRC = "reportToRead.csv";

    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        Reader reader = new FileReaderImpl();
        List<String> inputReport = reader.read(FILE_READ_SRC);
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
    }
}
