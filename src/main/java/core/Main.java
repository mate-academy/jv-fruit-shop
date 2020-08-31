package core;

import services.FileService;
import services.ReportService;

public class Main {
    public static void main(String[] args) {
        FileService fileService = new FileService();
        fileService.readFile("src/main/resources/fruits.csv");
        ReportService reportService = new ReportService();
        reportService.printReportIntoFile();
    }
}
