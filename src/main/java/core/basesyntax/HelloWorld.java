package core.basesyntax;

import core.basesyntax.readandwritefile.CsvReaderImpl;
import core.basesyntax.readandwritefile.CsvWriterImpl;
import core.basesyntax.servise.DataProcessorImpl;
import core.basesyntax.servise.ReportGeneratorImpl;
import java.util.List;
import java.util.Map;

public class HelloWorld {
    public static void main(String[] args) {
        CsvReaderImpl csvReader = new CsvReaderImpl();
        List<FruitTransaction> transactions = csvReader.readDataFromDataBase();

        DataProcessorImpl dataProcessor = new DataProcessorImpl();
        Map<String, Integer> fruitStore = dataProcessor.processTransactions(transactions);

        ReportGeneratorImpl reportGenerator = new ReportGeneratorImpl();
        List<String> report = reportGenerator.generateReport(fruitStore);

        CsvWriterImpl csvWriter = new CsvWriterImpl();
        csvWriter.writeReportToFile(report, "path_to_your_output_file.csv");
    }
}
