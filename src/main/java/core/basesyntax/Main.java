package core.basesyntax;

import core.basesyntax.service.CalculateData;
import core.basesyntax.service.GenerateReport;
import core.basesyntax.service.ParseDataService;
import core.basesyntax.service.ReadFromFile;
import core.basesyntax.service.WriteToFile;
import core.basesyntax.service.impl.CalculateDataImpl;
import core.basesyntax.service.impl.GenerateReportImpl;
import core.basesyntax.service.impl.ParseDataServiceImpl;
import core.basesyntax.service.impl.ReadFromFileImpl;
import core.basesyntax.service.impl.WriteToFileImpl;
import java.util.List;
import java.util.Map;

public class Main {
    private static final String INPUT_FILE_PATH = "src/main/resources/input.csv";
    private static final String OUTPUT_FILE_PATH = "src/main/resources/output.csv";

    public static void main(String[] args) {
        ReadFromFile readFromFile = new ReadFromFileImpl();
        ParseDataService parseDataService = new ParseDataServiceImpl();
        CalculateData calculateData = new CalculateDataImpl();
        GenerateReport generateReport = new GenerateReportImpl();
        WriteToFile writeToFile = new WriteToFileImpl();

        String data = readFromFile.getListFromFile(INPUT_FILE_PATH);
        List<String[]> list = parseDataService.parseData(data);
        Map<String, Integer> map = calculateData.calculateData(list);
        String report = generateReport.generateReport(map);
        writeToFile.writeToFile(report, OUTPUT_FILE_PATH);
    }
}
