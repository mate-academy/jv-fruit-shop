package core.basesyntax;

import model.FruitTransaction;
import service.*;
import service.impl.*;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String INPUT_FILE = "src/main/resources/reportToRead.csv";

    public static void main(String[] arg) throws IOException {

        FileReader fileReader = new FileReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        ShopService shopService = new ShopServiceImpl();
        List<String> readingFile = fileReader.read(INPUT_FILE);
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(readingFile);
        shopService.process(transactions);
    }
}
