package core.basesyntax;

import core.basesyntax.data.DataConverter;
import core.basesyntax.data.DataConverterImpl;
import core.basesyntax.reader.FileReader;
import core.basesyntax.reader.FileReaderImpl;
import core.basesyntax.transaction.FruitTransaction;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1. Read the data from the input CSV file
        final String filePathRead = "reportToRead.csv";
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read(filePathRead);
        // 2. Convert the incoming data into FruitTransactions list
        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);
    }
}
