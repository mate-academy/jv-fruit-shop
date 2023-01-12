package core.basesyntax;

import core.basesyntax.service.impl.GenerateReportImpl;
import core.basesyntax.service.impl.ProcessWithDataImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReadFromFileImpl readFromFile = new ReadFromFileImpl();
        ProcessWithDataImpl processWithData = new ProcessWithDataImpl();
        GenerateReportImpl generateReport = new GenerateReportImpl();
        WriteToFileImpl writeToFile = new WriteToFileImpl();

        List<String[]> list = readFromFile.getListFromFile(INPUT_FILE_PATH);
        Map<String, Integer> map = processWithData.processWithData(list);
        String report = generateReport.generateReport(map);
        writeToFile.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
