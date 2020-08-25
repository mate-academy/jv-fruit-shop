package core.basesyntax;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IllegalFormatException;
import java.util.IllegalFormatFlagsException;
import java.util.List;

public class ReadFromFile implements ReadableFile {
    private static final String COMMA_DELIMITER = ",";
    private static final String[] FILE_HEADER = new String[]{"type", "fruit", "quantity", "date"};

    public List<List<String>> getNewData(String fileName) throws IOException {
        if (fileName == null || fileName.length() < 4
                || !fileName.substring(fileName.length() - 4).equals(".csv")) {
            throw new IllegalArgumentException("You haven't indicated a file or have provided file "
                    + "with unsupported extension! Please, make sure to provide a CSV file");
        }
        List<List<String>> fileData = new ArrayList<>();
        try (BufferedReader textHolder = new BufferedReader(new FileReader(fileName))) {
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

    public boolean checkDataFormat(String[] lineFromFile, List<List<String>> fileData) {
        if (fileData.isEmpty() && !Arrays.equals(FILE_HEADER, lineFromFile)) {
            throw new IllegalFormatFlagsException("File header doesn't satisfy specified format");
        } else if (fileData.isEmpty()) {
            return true;
        }
        if (!StoreOperations.AVAILABLE_OPERATIONS.containsKey(lineFromFile[0])) {
            throw new IllegalFormatFlagsException("File provides unsupported operation type");
        }
        try {
            int fruitAmount = Integer.parseInt(lineFromFile[2]);
            LocalDate date = LocalDate.parse(lineFromFile[3]);
        } catch (IllegalFormatException | DateTimeParseException message) {
            throw new IllegalArgumentException(message);
        } catch (ArrayIndexOutOfBoundsException message) {
            throw new ArrayIndexOutOfBoundsException("The provided data was incomplete");
        }
        return true;
    }
}
