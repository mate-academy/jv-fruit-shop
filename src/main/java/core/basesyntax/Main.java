package core.basesyntax;

import core.basesyntax.service.ReadInfo;
import core.basesyntax.serviceimpl.*;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategyimpl.StrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadInfo readInfo = new ReadInfoCsv();
        FileHandlerCsvImpl csvFileHandler = new FileHandlerCsvImpl();
        ReportGenerate reportGenerate = new ReportGenerate();
        ReportWriter reportWriter = new ReportWriter();
        CalculateValues calculateValues = new CalculateValues();
        List<String> strings = readInfo.readInfo("example.csv");
        List<FruitTransaction> parsed = csvFileHandler.parse(strings);
        calculateValues.getFruitsAndValues(parsed);
        reportWriter.writeReportInFile("report.csv",reportGenerate.generateReport(Storage.fruits));
    }
}

