package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatFlagsException;
import java.util.List;

public class LocalFileReader implements CsvFileReader {
    private static final String[] FILE_HEADER = {"type", "fruit", "quantity", "date"};
    private static final String COMMA_DELIMITER = ",";
    private static DataParser parser = new DataParser();
    private final String filePath;

    public LocalFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<Transaction> readTransactionsFile() throws IOException {
        validateFilePath(filePath);
        List<Transaction> fileData = new ArrayList<>();
        try (BufferedReader textHolder = new BufferedReader(new FileReader(filePath))) {
            validateFileHeader(textHolder.readLine());
            String line;
            while ((line = textHolder.readLine()) != null) {
                Transaction newTransaction = parser.parseLineToTransaction(line);
                fileData.add(newTransaction);
            }
        }
        return fileData;
    }

    private void validateFilePath(String filePath) {
        if (filePath == null || filePath.length() < 4 || !filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("You haven't indicated a file or have provided file "
                    + "with unsupported extension! Please, make sure to provide a CSV file");
        }
    }

    private void validateFileHeader(String line) {
        if (line != null && !Arrays.equals(FILE_HEADER, line.split(COMMA_DELIMITER))) {
            throw new IllegalFormatFlagsException("File header doesn't satisfy specified format");
        }
    }
}
