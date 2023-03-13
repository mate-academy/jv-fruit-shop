package core.basesyntax;

import core.basesyntax.service.impl.CsvReader;
import core.basesyntax.service.impl.CsvWriter;
import core.basesyntax.service.impl.FruitTransaction;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        String path = "src/main/java/core/basesyntax/Transactions.csv";

        CsvReader csvReader = new CsvReader(path);
        List<FruitTransaction> fruitTransactionList = csvReader.readFromCsv(path);
        fruitTransactionList.forEach(FruitTransaction::executeStrategy);
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.writeToCsvFile();

    }
}


