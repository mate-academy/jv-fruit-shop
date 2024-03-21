package core.basesyntax;

import core.basesyntax.service.ReadInfo;
import core.basesyntax.serviceimpl.CalculateValues;
import core.basesyntax.serviceimpl.FileHandlerCsvImpl;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.ReadInfoCsv;
import core.basesyntax.serviceimpl.ReportGenerate;
import core.basesyntax.serviceimpl.ReportWriter;
import core.basesyntax.storage.Storage;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadInfo readInfo = new ReadInfoCsv();
        FileHandlerCsvImpl csvFileHandler = new FileHandlerCsvImpl();
        ReportGenerate reportGenerate = new ReportGenerate();
        ReportWriter reportWriter = new ReportWriter();
        CalculateValues calculateValues = new CalculateValues();
        List<String> strings = readInfo.readInfo("src/main/resources/example2.csv");
        List<FruitTransaction> parsed = csvFileHandler.parse(strings);
        calculateValues.getFruitsAndValues(parsed);
        reportWriter.writeReportInFile("src/main/resources/report.csv",
                reportGenerate.generateReport(Storage.fruits));
    }
}

