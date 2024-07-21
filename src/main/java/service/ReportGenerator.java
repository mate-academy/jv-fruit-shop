package service;

import service.impl.Storage;

public interface ReportGenerator {
    String getReport(Storage storage);
}
