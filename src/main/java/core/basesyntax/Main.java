package core.basesyntax;

import core.basesyntax.db.TransactionList;
import core.basesyntax.service.CsvFormatter;
import core.basesyntax.service.CsvReader;
import core.basesyntax.service.CsvWriter;

public class Main {
    public static void main(String[] args) {
        String reportPath = "src/main/java/core/basesyntax/resources/Report.csv";
        String fileContent = CsvReader.readFile("src/main/java/core/basesyntax"
                + "/resources/Input.csv");
        CsvFormatter.csvToStringArrayList(fileContent);
        LineProcessor.processLine(TransactionList.getTransactionList());
        String report = ReportFormatter.formatReportAsCsvString();
        CsvWriter.generateCsvReport(reportPath, report);
    }
}
