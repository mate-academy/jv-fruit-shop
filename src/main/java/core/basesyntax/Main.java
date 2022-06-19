package core.basesyntax;

import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvReader csvReader = new CsvReader();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        RawLineProcessor rawLineProcessor = new RawLineProcessor();
        rawLineProcessor.fileToMap(fileContent);
        ReportFormatter reportFormatter = new ReportFormatter();
        String report = reportFormatter.formatReportAsCsvString();
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.generateCsvReport(reportPath, report);
    }
}
