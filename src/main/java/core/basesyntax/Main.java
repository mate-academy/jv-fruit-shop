package core.basesyntax;

import dao.CsvReaderImpl;
import dao.CsvWriterImpl;
import dao.CustomFileReader;
import dao.CustomFileWriter;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;
import service.Operation;
import service.ReportCreator;
import service.impl.BalanceCalculatorImpl;
import service.impl.DataFruitConverterImpl;
import service.impl.ReportGeneratorImpl;

public class Main {
    public static final String INPUT_FILE_NAME = "src/main/resources/reportToRead.csv";
    public static final String OUTPUT_FILE_NAME = "src/main/resources/reportToWrite.csv";

    public static void main(String[] args) {
        CustomFileReader fileReader = new CsvReaderImpl();
        List<String[]> inputReport = fileReader.readFile(INPUT_FILE_NAME);

        DataConverter dataConverter = new DataFruitConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        Operation operation = new BalanceCalculatorImpl();
        ReportCreator reportCreator = new ReportGeneratorImpl();
        List<String[]> finalReport = reportCreator
                .createReport(operation.update(transactions));
        CustomFileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeFile(OUTPUT_FILE_NAME, finalReport);
    }
}
