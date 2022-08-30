package core.basesyntax.service;

public interface ReportCreatorService<T> {
    String createReport(T data);
}
