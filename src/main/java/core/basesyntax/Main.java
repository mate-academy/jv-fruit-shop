package core.basesyntax;

import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public class Main {
    private static final String PATH_TO_FILE = "src/main/resources/Transactions.csv";

    public static void main(String[] args) {

        CsvReader csvReader = new CsvReader(PATH_TO_FILE);
        List<FruitTransaction> fruitTransactionList = csvReader.readFromCsv(PATH_TO_FILE);
        fruitTransactionList.forEach(FruitTransaction::executeStrategy);
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeToCsvFile();

    }
}


