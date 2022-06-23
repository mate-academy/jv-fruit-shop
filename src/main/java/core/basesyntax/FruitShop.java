package core.basesyntax;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.CsvFileReader;
import core.basesyntax.service.CsvFileWriter;
import core.basesyntax.service.ReportFormatter;
import core.basesyntax.service.StringListProcessor;
import core.basesyntax.service.handlers.OperationStrategy;
import core.basesyntax.service.handlers.OperationStrategyImpl;
import core.basesyntax.service.impl.CsvFileReaderImpl;
import core.basesyntax.service.impl.CsvFileWriterImpl;
import core.basesyntax.service.impl.ReportFormatterImpl;
import core.basesyntax.service.impl.StringListProcessorImpl;
import java.util.List;

public class FruitShop {
    private static final String INPUT_FILE_PATH = "src/main/java/core/basesyntax/"
            + "resources/Input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/java/core/basesyntax/"
            + "resources/Report.csv";

    public static void main(String[] args) {
        CsvFileReader csvFileReader = new CsvFileReaderImpl();
        List<String> fileContent = csvFileReader.readCsvFileToStringList(INPUT_FILE_PATH);

        StringListProcessor stringListProcessor = new StringListProcessorImpl();
        List<Transaction> transactionList = stringListProcessor
                .stringListToFruitIntegerMap(fileContent);

        OperationStrategy operationStrategy = new OperationStrategyImpl();
        transactionList.forEach(transaction -> operationStrategy
                                                .get(transaction.getAbbreviature())
                                                .processOperation(transaction.getAbbreviature(),
                                                        transaction.getFruit(),
                                                        transaction.getQuantity()));

        ReportFormatter reportFormatter = new ReportFormatterImpl();
        String report = reportFormatter.formatReportAsCsvString();

        CsvFileWriter csvFileWriter = new CsvFileWriterImpl();
        csvFileWriter.writeReportToFile(OUTPUT_FILE_PATH, report);
    }
}
