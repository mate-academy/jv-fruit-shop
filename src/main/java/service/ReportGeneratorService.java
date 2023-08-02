package service;

import db.*;

public interface ReportGeneratorService {
    /**
     * Generates a report based on the processed data.
     *
     * @return Report as a string.
     */
    String generateReport();
}