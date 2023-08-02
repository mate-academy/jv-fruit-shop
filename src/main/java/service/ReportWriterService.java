package service;

import java.io.*;

public interface ReportWriterService {
    /**
     * Writes the report to the output file.
     *
     * @param report         The report data as a string.
     * @param outputFilePath The file path where the report will be written.
     * @throws IOException If there is an error writing the report to the file.
     */
    void writeReportToFile(String report, String outputFilePath) throws IOException;
}
