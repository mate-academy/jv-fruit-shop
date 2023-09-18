package core.basesyntax.servise.fileservice;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileReaderUtilityImp implements FileReaderUtility {
    private static final int INDEX_TITULAR_LINE = 0;

    @Override
    public ArrayList<String> retrieveFileData(String file) {
        ArrayList<String> date = new ArrayList<>();
        File fileDate = new File(file);
        if (!fileDate.exists()) {
            throw new RuntimeException("File missing");
        }
        if (fileDate.length() == 0) {
            return new ArrayList<String>();
        }
        try (BufferedReader reader = new BufferedReader(new FileReader(fileDate))) {
            String line = reader.readLine();
            while (line != null) {
                date.add(line);
                line = reader.readLine();
            }
            date.remove(INDEX_TITULAR_LINE);
        } catch (IOException e) {
            throw new RuntimeException("error reading file", e);
        }
        return date;
    }
}
