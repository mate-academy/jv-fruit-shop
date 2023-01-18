package service;

import strategy.StoreOperationStrategy;

public interface ReportService {
    String createReport(StoreOperationStrategy storeOperationStrategy);
}
