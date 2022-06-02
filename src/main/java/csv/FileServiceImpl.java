package csv;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileRadService,FileWriteService {
    @Override
    public List<String> readFile(String readfilepath) {
        String csvline;
        List<String> csvfilelist = new ArrayList<>();
        try (BufferedReader fileBufferedReader = new BufferedReader(new FileReader(readfilepath))) {
            csvline = fileBufferedReader.readLine();
            while ((csvline = fileBufferedReader.readLine()) != null) {
                csvfilelist.add(csvline);
            }
            return csvfilelist;
        } catch (IOException e) {
            throw new RuntimeException("Can't open input csv file " + readfilepath,e);
        }

    }

    @Override
    public void writeFile(String writeFilePath, List<String> writelist) {
        try (BufferedWriter fileBufferedWriter
                     = new BufferedWriter(new FileWriter(writeFilePath))) {
            for (String filestring: writelist) {
                fileBufferedWriter.write(filestring + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't open output file" + writeFilePath,e);
        }
    }
}
