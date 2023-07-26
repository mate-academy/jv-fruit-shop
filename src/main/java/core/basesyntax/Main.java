package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataParser;
import core.basesyntax.service.FileReader;
import core.basesyntax.service.FileWriter;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.ReportCreator;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.DataParserImpl;
import core.basesyntax.service.impl.OperationProcessImpl;
import core.basesyntax.service.impl.ReportCreatorImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        FileReader fileReader = new CsvFileReader();
        List<String> lines = fileReader.read("src/main/resources/input.csv");
        DataParser dataParser = new DataParserImpl();
        List<FruitTransaction> transactions = dataParser.parse(lines);
        OperationProcess operationProcess = new OperationProcessImpl();
        operationProcess.processData(transactions);
        ReportCreator reportCreator = new ReportCreatorImpl();
        String report = reportCreator.parse();
        FileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report, "src/main/resources/dailyReport");
    }
}
