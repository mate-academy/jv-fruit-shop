package core.basesyntax;

public class Main {
    public static void main(String[] args) {
        new CSVDataImporter().importData();
        new CSVReportWriter().writeReport();
    }
}
