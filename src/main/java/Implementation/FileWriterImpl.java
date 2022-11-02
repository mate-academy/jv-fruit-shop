package Implementation;

import Service.FileWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;

public class FileWriterImpl  implements FileWriter {
    @Override
    public void writeToFile(String data, String pathToFile) {
File requiredFile=new File(pathToFile);
        try {
            requiredFile.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException();
        }
        try {
            Files.write(requiredFile.toPath(), data.getBytes(), StandardOpenOption.APPEND);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
