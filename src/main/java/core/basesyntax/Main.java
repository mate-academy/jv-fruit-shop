package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.TransactionParserImpl;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> dataFromInputFile = fileReader.getDataFromInputFile("inputData.csv");
        TransactionParser transactionParser = new TransactionParserImpl();
        List<FruitTransaction> fruitTransactions = transactionParser.parsOf(dataFromInputFile);
        System.out.println(fruitTransactions);
    }
}
