package core.basesyntax;

import core.basesyntax.db.TransactionList;
import core.basesyntax.service.CsvFormatter;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;

public class Main {
    public static void main(String[] args) {

        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        CsvReader csvReader = new CsvReader();
        String fileContent = csvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        CsvFormatter csvFormatter = new CsvFormatter();
        csvFormatter.csvToStringArrayList(fileContent);
        LineProcessor lineProcessor = new LineProcessor();
        lineProcessor.processLine(TransactionList.getTransactionList());
        ReportFormatter reportFormatter = new ReportFormatter();
        String report = reportFormatter.formatReportAsCsvString();
        CsvWriter csvWriter = new CsvWriter();
        csvWriter.generateCsvReport(reportPath, report);
    }
}
