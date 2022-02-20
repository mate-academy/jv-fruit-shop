package service;

import dao.service.FileService;
import java.util.List;
import service.parse.ParseInput;
import service.report.GenerateFruitReport;

public class FruitShop {
    private static final String PATH_TO_WRITE = "src/main/java/source/report.csv";
    private static final String PATH_TO_READ = "src/main/java/source/activities.csv";

    public static void main(String[] args) {
        FileService fileService = new FileService();
        List<String> rawData = fileService.read(PATH_TO_READ);
        ParseInput parseInput = new ParseInput();
        List<String[]> parsedData = parseInput.parse(rawData);
        ProcessInputData processInputData = new ProcessInputData();
        processInputData.processInput(parsedData);
        GenerateFruitReport generateFruitReport = new GenerateFruitReport();
        String report = generateFruitReport.getReport();
        fileService.write(report, PATH_TO_WRITE);
    }
}
