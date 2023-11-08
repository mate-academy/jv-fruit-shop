package core.basesyntax;

import core.basesyntax.db.FruitDB;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataReader<FruitTransaction> dataReader = new DataReaderImpl();
        List<FruitTransaction> fruitTransactions;
        String filePart = "src/main/resources/inputData.csv";

        try {
            fruitTransactions = dataReader.readData(filePart);
        } catch (IOException e) {
            System.out.println("Error reading input file: " + e.getMessage());
            return;
        }
        Map<String, Integer> dataBase = FruitDB.FRUIT_DATA_BASE;
        FruitTransactionStrategy transactionStrategy = new FruitTransactionStrategy();
        dataBase = transactionStrategy.operationFromFruit(dataBase, fruitTransactions);
        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.writeData(dataBase);
    }
}
