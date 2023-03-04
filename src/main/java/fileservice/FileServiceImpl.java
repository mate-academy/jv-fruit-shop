package fileservice;

import errors.ErrorWritingDataToFile;
import errors.InvalidFileExtension;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {
    @Override
    public List<String> read(String file) {
        if (!file.endsWith(".csv")) {
            throw new InvalidFileExtension("Wrong file extension.");
        }

        List<String> dataFromCsvFile = new ArrayList();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                dataFromCsvFile.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read file", e);
        }

        return dataFromCsvFile;
    }

    @Override
    public void write(String file, String content) {
        if (!file.endsWith(".csv")) {
            throw new InvalidFileExtension("Invalid file extension, extension must be 'csv'.");
        }
        File newFile = new File(file);
        try {
            newFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException("Can't create file", e);
        }

        try (PrintWriter writer = new PrintWriter(file)) {
            StringBuilder builder = new StringBuilder();
            String[] splitForWritingInNewFile = content.split(",");

            for (int i = 0; i < splitForWritingInNewFile.length; i += 2) {
                builder.append(splitForWritingInNewFile[i])
                        .append(",")
                        .append(splitForWritingInNewFile[i + 1])
                        .append("\n");
            }
            writer.write(builder.toString());
            writer.close();
        } catch (FileNotFoundException e) {
            throw new ErrorWritingDataToFile("Can't write data in file!");
        }
    }
}
