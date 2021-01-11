package core.basesyntax.service.work.with.file;

public interface Report {
    String writeReportToString();

    void writeReportToFile(String report, String toFileName);
}
