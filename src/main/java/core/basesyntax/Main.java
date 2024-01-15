package core.basesyntax;

import core.basesyntax.dao.FruitDao;
import core.basesyntax.dao.FruitDaoImpl;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FileContentCreator;
import core.basesyntax.service.FileDataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.service.impl.FileContentCreatorImpl;
import core.basesyntax.service.impl.FileDataParserCsvImpl;
import core.basesyntax.service.impl.FileReaderCsvImpl;
import core.basesyntax.service.impl.FileWriterCsvImpl;
import core.basesyntax.service.impl.FruitTransactionProcessorImpl;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.BalanceOperationHandler;
import core.basesyntax.strategy.impl.PurchaseOperationHandler;
import core.basesyntax.strategy.impl.ReturnOperationHandler;
import core.basesyntax.strategy.impl.SupplyOperationHandler;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        FruitDao fruitDao = new FruitDaoImpl();

        FileReader readerFile = new FileReaderCsvImpl();
        FileWriter fileWriter = new FileWriterCsvImpl();
        FileDataParser fileDataParser = new FileDataParserCsvImpl();
        FileContentCreator contentFileCreator = new FileContentCreatorImpl(fruitDao);

        OperationStrategy operationStrategy = new OperationStrategy(Map.of(
                FruitTransaction.Operation.BALANCE, new BalanceOperationHandler(fruitDao),
                FruitTransaction.Operation.PURCHASE, new PurchaseOperationHandler(fruitDao),
                FruitTransaction.Operation.RETURN, new ReturnOperationHandler(fruitDao),
                FruitTransaction.Operation.SUPPLY, new SupplyOperationHandler(fruitDao)
        ));

        FruitTransactionProcessor fruitTransactionProcessor =
                new FruitTransactionProcessorImpl(operationStrategy);

        List<String> dataFromFile = readerFile
                .readFromFile("src/main/resources/input_file.csv");

        List<FruitTransaction> transactions = fileDataParser.parseData(dataFromFile);
        fruitTransactionProcessor.processTransactions(transactions);

        String fileContent = contentFileCreator.createFileContent();
        fileWriter.writeToFile(fileContent, "src/main/resources/output_file.csv");
    }
}
