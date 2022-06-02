package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CsvReadProcessor {

    private String[] headers;
    private String[] fields;
    private String delimiter;
    private BufferedReader csvBufferReader;
    private FileReader csvFileReader;

    public int openCsv(String inCsvFilePath) {

        try {
            delimiter = ",";
            csvFileReader = new FileReader(inCsvFilePath);
            csvBufferReader = new BufferedReader(csvFileReader);
            headers = csvBufferReader.readLine().split(delimiter);
            readNext();
        } catch (IOException e) {
            throw new RuntimeException("Can't find file by path: " + inCsvFilePath, e);
        }
        return headers.length;
    }

    public boolean readNext() {
        try {
            String csvline;
            if ((csvline = csvBufferReader.readLine()) != null) {
                fields = csvline.split(delimiter);
                return true;
            } else {
                return false;
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open file",e);
        }
    }

    public String getField(String name) {

        for (int i = 0;i < headers.length;i++) {
            if (headers[i].toUpperCase().equals(name.toUpperCase())) {
                return fields[i];
            }
        }
        return null;
    }
}
