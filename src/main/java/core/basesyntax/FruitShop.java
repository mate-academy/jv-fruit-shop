package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.TransactionConvertor;
import core.basesyntax.service.handlers.OperationStrategy;
import core.basesyntax.service.handlers.OperationStrategyImpl;
import core.basesyntax.service.impl.FileReaderImpl;
import core.basesyntax.service.impl.FileWriterImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.TransactionConvertorImpl;
import java.util.List;

public class FruitShop {
    private static final String INPUT_FILE_PATH = "src/main/java/core/basesyntax/"
            + "resources/Input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/core/basesyntax/"
            + "resources/Report.csv";

    public static void main(String[] args) {
        FileReader fileReader = new FileReaderImpl();
        List<String> fileContent = fileReader.readCsvFileToStringList(INPUT_FILE_PATH);

        TransactionConvertor transactionConvertor = new TransactionConvertorImpl();
        List<Transaction> transactionList = transactionConvertor
                .convert(fileContent);

        OperationStrategy operationStrategy = new OperationStrategyImpl();
        transactionList.forEach(transaction -> operationStrategy
                                                .get(transaction.getAbbreviature())
                                                .handle(
                                                        transaction.getFruit(),
                                                        transaction.getQuantity()));

        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.create();

        FileWriter fileWriter = new FileWriterImpl();
        fileWriter.writeToFile(OUTPUT_FILE_PATH, report);
    }
}
