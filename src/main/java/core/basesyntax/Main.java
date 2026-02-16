package core.basesyntax;

import java.util.*;

public class Main {
    public static void main( String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> inputReport = fileReader.read();

        DataConverter dataConverter = new DataConverterImpl();
        List<FruitTransaction> fruitTransactionList = dataConverter.convert(inputReport);




    }
}
