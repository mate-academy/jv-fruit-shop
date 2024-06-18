package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import core.basesyntax.service.DataProcess;
import core.basesyntax.service.DataReader;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.ReportToFile;
import core.basesyntax.service.impl.DataConverterImpl;
import core.basesyntax.service.impl.DataProcessImpl;
import core.basesyntax.service.impl.DataReaderImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import core.basesyntax.service.impl.ReportToFileImpl;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {

        DataReader dataReader = new DataReaderImpl();
        DataConverter dataConverter = new DataConverterImpl();
        DataProcess dataProcess = new DataProcessImpl();
        ReportCreator reportCreator = new ReportCreatorImpl();
        ReportToFile reportToFile = new ReportToFileImpl();

        List<String> readFile = dataReader.read("src/main/resources/input.csv");
        List<FruitTransaction> transactions = dataConverter.convert(readFile);
        Map<String, Integer> processedTransactions = dataProcess.process(transactions);
        List<String> report = reportCreator.createReport(processedTransactions);
        reportToFile.writeReportToFile(report, "src/main/resources/report.csv");
    }
}
