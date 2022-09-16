package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ShopDaoImpl implements ShopDao {
    private static final String FIRST_LINE_REPORT = "fruit,quantity";

    @Override
    public List<String> readFromFile(File file) {
        List<String> result = new ArrayList<>();
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
            bufferedReader.readLine();
            String value = bufferedReader.readLine();
            if (value == null) {
                return Collections.emptyList();
            }
            while (value != null) {
                result.add(value);
                value = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file" + file, e);
        }
        return result;
    }

    @Override
    public void writeToFile(File file, String data) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file, true))) {
            bufferedWriter.write(FIRST_LINE_REPORT);
            bufferedWriter.write(System.lineSeparator());
            bufferedWriter.write(data);
        } catch (IOException e) {
            throw new RuntimeException("Can't write the file" + file, e);
        }
    }
}
