package core.basesyntax;

import core.basesyntax.service.ReadInfo;
import core.basesyntax.serviceimpl.*;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategyimpl.StrategyImpl;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadInfo readInfo = new ReadInfoCsv();
        List<String> strings = readInfo.readInfo("example.csv");
        FileHandlerCsvImpl csvFileHandler = new FileHandlerCsvImpl();
        StrategyImpl strategy = new StrategyImpl();
        ReportGenerate reportGenerate = new ReportGenerate();
        ReportWriter reportWriter = new ReportWriter();
        CalculateValues calculateValues = new CalculateValues();
        List<FruitTransaction> parsed = csvFileHandler.parse(strings);
        calculateValues.getFruitsAndValues(parsed);
        reportWriter.writeReportInFile("report.csv",reportGenerate.generateReport(Storage.fruits));
    }
}

