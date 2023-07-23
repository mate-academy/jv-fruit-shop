package core.basesyntax;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.CustomFileReader;
import core.basesyntax.service.CustomFileWriter;
import core.basesyntax.service.OperationProcess;
import core.basesyntax.service.ReadParser;
import core.basesyntax.service.WriteParser;
import core.basesyntax.service.impl.CsvFileReader;
import core.basesyntax.service.impl.CsvFileWriter;
import core.basesyntax.service.impl.OperationProcessImpl;
import core.basesyntax.service.impl.ReadParserImpl;
import core.basesyntax.service.impl.WriteParserImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomFileReader fileReader = new CsvFileReader();
        List<String> lines = fileReader.read("input.csv");
        ReadParser readParser = new ReadParserImpl();
        List<FruitTransaction> transactions = readParser.parse(lines);
        OperationProcess operationProcess = new OperationProcessImpl();
        operationProcess.processData(transactions);
        WriteParser writeParser = new WriteParserImpl();
        String report = writeParser.parse();
        CustomFileWriter fileWriter = new CsvFileWriter();
        fileWriter.write(report, "dailyReport");
    }
}
