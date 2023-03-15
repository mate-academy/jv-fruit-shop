package serviceimpl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import service.ReaderService;

public class ReaderImpl implements ReaderService {
    @Override
    public List<String> read(File inputFileName) {
        List<String> list = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                list.add(line);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File " + inputFileName + " not found!", e);
        } catch (IOException e) {
            throw new RuntimeException("File " + inputFileName + " can't be read!", e);
        }
        return list;
    }
}
