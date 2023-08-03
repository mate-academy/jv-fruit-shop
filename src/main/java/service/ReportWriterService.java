package service;

import java.io.IOException;

public interface ReportWriterService {
    /**
     * Writes the report to the output file.mvn clean
     *
     * @param report         The report data as a string.
     * @throws IOException If there is an error writing the report to the file.
     */
    void writeReportToFile(String report) throws IOException;
}
