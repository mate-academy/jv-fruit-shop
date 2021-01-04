package core.basesyntax.service.fileworker;

public interface WorkWithReport {
    String readReport(String fileName);

    void writeReport(String report, String fileName);
}
