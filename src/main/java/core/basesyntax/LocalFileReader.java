package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatFlagsException;
import java.util.List;

public class LocalFileReader {
    private static final String COMMA_DELIMITER = ",";
    private static final String[] FILE_HEADER = new String[]{"type", "fruit", "quantity", "date"};
    private final String filePath;

    public LocalFileReader(String filePath) {
        this.filePath = filePath;
    }

    public List<List<String>> readFromFile() throws IOException {
        validateFilePath(filePath);
        List<List<String>> fileData = new ArrayList<>();
        try (BufferedReader textHolder = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = textHolder.readLine()) != null) {
                String[] lineFromFile = line.split(COMMA_DELIMITER);
                checkDataFormat(lineFromFile, fileData);
                fileData.add(Arrays.asList(lineFromFile));
            }
        }
        if (fileData.size() > 0) {
            fileData.remove(0);
        }
        return fileData;
    }

    private void validateFilePath(String filePath) {
        if (filePath == null || filePath.length() < 4 || !filePath.endsWith(".csv")) {
            throw new IllegalArgumentException("You haven't indicated a file or have provided file "
                    + "with unsupported extension! Please, make sure to provide a CSV file");
        }
    }

    private void checkDataFormat(String[] lineFromFile, List<List<String>> fileData) {
        if (fileData.isEmpty() && !Arrays.equals(FILE_HEADER, lineFromFile)) {
            throw new IllegalFormatFlagsException("File header doesn't satisfy specified format");
        } else if (fileData.isEmpty()) {
            return;
        }
        if (!StoreOperations.AVAILABLE_OPERATIONS.containsKey(lineFromFile[0])) {
            throw new IllegalFormatFlagsException("File provides unsupported operation type");
        }
        try {
            int fruitAmount = Integer.parseInt(lineFromFile[2]);
            LocalDate date = LocalDate.parse(lineFromFile[3]);
        } catch (NumberFormatException | DateTimeParseException
                | ArrayIndexOutOfBoundsException message) {
            throw new IllegalArgumentException("File provides wrong data format");
        }
    }
}
