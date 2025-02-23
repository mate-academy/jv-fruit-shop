package core.basesyntax;

import dao.CsvReaderImpl;
import dao.CsvWriterImpl;
import dao.CustomFileReader;
import dao.CustomFileWriter;
import java.util.List;
import service.BalanceCalculatorImpl;
import service.OperationHandler;

public class Main {
    public static void main(String[] args) {
        CustomFileReader fileReader = new CsvReaderImpl();
        List<String[]> inputReport = fileReader.readFile("reportToRead.csv");

        DataConverter dataConverter = new DataFruitConverterImpl();
        List<FruitTransaction> transactions = dataConverter.convertToTransaction(inputReport);

        OperationHandler operationHandler = new BalanceCalculatorImpl();
        ReportCreator reportCreator = new BalanceReportImpl();
        List<String[]> finalReport = reportCreator
                .createReport(operationHandler.update(transactions));
        CustomFileWriter fileWriter = new CsvWriterImpl();
        fileWriter.writeFile("finalReport.csv", finalReport);
    }
}
