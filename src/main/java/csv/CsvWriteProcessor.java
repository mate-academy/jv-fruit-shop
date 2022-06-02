package csv;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class CsvWriteProcessor {
    private String[] headers;
    private String[] fields;
    private String delimiter;
    private BufferedWriter csvBufferWrite;
    private FileWriter csvFileWrite;

    public void createCsv(String outCsvFilePath, String[] headers) {
        try {
            delimiter = ",";
            csvFileWrite = new FileWriter(outCsvFilePath);
            csvBufferWrite = new BufferedWriter(csvFileWrite);
            this.headers = headers;
            fields = new String[headers.length];
            csvBufferWrite.write(String.join(delimiter, headers) + System.lineSeparator());
            csvBufferWrite.flush();

        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + outCsvFilePath, e);
        }
    }

    public void setField(String fieldName,String fieldValue) {

        for (int i = 0;i < headers.length;i++) {
            if (headers[i].equals(fieldName)) {
                fields[i] = fieldValue;
                return;
            }
        }
    }

    public void write() {
        try {
            csvBufferWrite.write(String.join(delimiter, fields) + System.lineSeparator());
            for (int i = 0; i < fields.length; i++) {
                fields[i] = "";
            }
            csvBufferWrite.flush();

        } catch (IOException e) {
            throw new RuntimeException("Can't write to file", e);
        }
    }
}
