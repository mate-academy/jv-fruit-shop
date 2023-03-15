package core.basesyntax;

import core.basesyntax.db.Storage;
import core.basesyntax.impl.GenerateReportImpl;
import core.basesyntax.impl.ProcessDataFromFileImpl;
import core.basesyntax.impl.ReadDataFromFileImpl;
import core.basesyntax.impl.WriteReportToFileImpl;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.ProcessDataFromFile;
import core.basesyntax.service.ReadDataFromFile;
import core.basesyntax.service.WriteReportToFile;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadDataFromFile readDataFromFile = new ReadDataFromFileImpl();
        final List<String> readData = readDataFromFile.readData();

        ProcessDataFromFile processDataFromFile = new ProcessDataFromFileImpl();
        final List<String[]> processData = processDataFromFile.processData(readData);

        GenerateReport generateReport = new GenerateReportImpl();
        generateReport.generateReport(processData);

        WriteReportToFile writeReportToFile = new WriteReportToFileImpl();
        writeReportToFile.writeData(Storage.fruits);
    }
}
