package core.basesyntax.service;

public interface ReportService<T, R> {
    R getReport(T data, String header);
}
