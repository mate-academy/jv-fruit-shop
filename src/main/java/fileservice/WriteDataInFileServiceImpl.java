package fileservice;

import errors.ErrorWritingDataToFile;
import errors.InvalidFileExtension;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteDataInFileServiceImpl implements WriteDataInFileService {
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
