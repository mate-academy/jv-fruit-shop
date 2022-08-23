package core.basesyntax.servce;

public interface FileWriter {
    String REPORT_FILE_NAME = "src/main/resources/report.csv";

    void writeToFile(String data);
}
