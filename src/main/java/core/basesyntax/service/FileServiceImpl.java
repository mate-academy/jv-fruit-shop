package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readDataFromFile(File file) {
        List<String> retList = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line = reader.readLine();
            while (line != null) {
                retList.add(line);
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("FileNotFoundException: ", e);
        } catch (IOException e) {
            throw new RuntimeException("IOException: ", e);
        }
        return retList;
    }

    @Override
    public void writeDataToFile(List<String> data, File file) {
        //File file = new File(fileName);//если передавать в метод не файл, а имя файла
        try (BufferedWriter bufferedWriter =
                     new BufferedWriter(new FileWriter(file, true))) {
            for (String lineData: data) {
                bufferedWriter.write(lineData + System.lineSeparator());
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("IOException during writing to file " + file.getName(), e);
        }
    }

    @Override
    public File createNewFile(String fileFullPath) {
        File file = new File(fileFullPath);
        file.getParentFile().mkdirs(); //to create directories for file
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

}
