package core.basesyntax;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileServiceImpl implements FileService {

    @Override
    public List<String> readFile(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader((fileName)))) {
            while (reader.ready()) {
                result.add(reader.readLine().trim());
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot read the file", e);
        }
        result.remove(0); //delete heading
        return result;
    }

    @Override
    public void writeFile(String filename, String report) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter((filename)))) {
            writer.write(report);
        } catch (IOException e) {
            throw new RuntimeException("Cannot write to file", e);
        }
    }
}
