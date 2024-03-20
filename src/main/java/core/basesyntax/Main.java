package core.basesyntax;

import core.basesyntax.service.ReadInfo;
import core.basesyntax.serviceimpl.FileHandlerCsvImpl;
import core.basesyntax.serviceimpl.FruitTransaction;
import core.basesyntax.serviceimpl.ReadInfoCsv;
import core.basesyntax.serviceimpl.ReportGenerate;
import core.basesyntax.serviceimpl.ReportWriter;
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
        List<FruitTransaction> parsed = csvFileHandler.parse(strings);
        for (FruitTransaction operation : parsed) {
            strategy.get(operation.getOperation())
                    .calculateValue(operation.getFruit(), operation.getQuantity());
        }
        reportWriter.writeReportInFile("report.csv",reportGenerate.generateReport(Storage.fruits));
    }
}

