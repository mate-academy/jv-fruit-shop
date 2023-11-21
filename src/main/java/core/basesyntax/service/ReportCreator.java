package core.basesyntax.service;

public interface ReportCreator<T> {
    String createReport(T source);
}
