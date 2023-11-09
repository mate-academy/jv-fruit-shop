package core.basesyntax;

import core.basesyntax.db.FruitDB;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.DataWriter;
import core.basesyntax.service.LineParser;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.DataWriterImpl;
import core.basesyntax.service.impl.LineParserImpl;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        DataReader<String> dataReader = new DataReaderImpl();
        List<String> inputData = dataReader.dataFromFile();
        LineParser<FruitTransaction> lineParser = new LineParserImpl();
        List<FruitTransaction> fruitTransactions = lineParser.createListOfTransactions(inputData);
        Map<String, Integer> dataBase = FruitDB.FRUIT_DATA_BASE;
        FruitTransactionStrategy transactionStrategy = new FruitTransactionStrategy();
        dataBase = transactionStrategy.operationFromFruit(dataBase, fruitTransactions);
        DataWriter dataWriter = new DataWriterImpl();
        dataWriter.writeData(dataBase);
    }
}
