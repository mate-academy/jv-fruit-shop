package core.basesyntax;

import java.io.IOException;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;
import service.FileReader;
import service.ShopService;
import service.impl.DataConverterImpl;
import service.impl.FileReaderImpl;
import service.impl.ShopServiceImpl;

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
