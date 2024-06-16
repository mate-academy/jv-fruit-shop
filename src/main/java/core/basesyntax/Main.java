package core.basesyntax;

import core.basesyntax.dataservices.DataConverter;
import core.basesyntax.dataservices.DataConverterImpl;
import core.basesyntax.dataservices.DataProcess;
import core.basesyntax.dataservices.DataProcessImpl;
import core.basesyntax.dataservices.DataReader;
import core.basesyntax.dataservices.DataReaderImpl;
import core.basesyntax.reportservices.ReportCreator;
import core.basesyntax.reportservices.ReportCreatorImpl;
import core.basesyntax.reportservices.ReportToFile;
import core.basesyntax.reportservices.ReportToFileImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        String inputFilePath = "src/main/resources/input.csv";
        String outputFilePath = "src/main/resources/report.csv";

        DataReader dataReader = new DataReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        DataProcess dataProcess = new DataProcessImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportToFile reportToFile = new ReportToFileImpl();

        List<String> readFile = dataReader.read(inputFilePath);
        List<FruitTransaction> transactions = dataConverter.convert(readFile);
        Map<String,Integer> processedTransactions = dataProcess.process(transactions);
        List<String> report = reportCreator.report(processedTransactions);
        reportToFile.writeReportToFile(report, outputFilePath);
    }
}
