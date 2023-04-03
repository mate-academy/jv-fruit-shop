package core.basesyntax.service;

public interface ReportProcessor<T, R> {
    R getReport(T data, String header);
}
