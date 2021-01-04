package core.basesyntax.service.work.with.file;

public interface Report {
    String writeReport(String fromFileName);

    void createReport(String fromFileName);

    void writeReportToFile(String fromFileName);
}
