package core.basesyntax.service.impl;

import core.basesyntax.service.FileService;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FileServiceImpl implements FileService {
    private static final String SPLIT_BY = ",";

    @Override
    public List<String> read(String filePath) {
        List<String> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String row;
            while ((row = reader.readLine()) != null) {
                data.add(row);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (data.size() > 0) {
            data.remove(0);
        }
        return data;
    }

    @Override
    public List<List<String>> readByPattern(String filePath, String pattern) {
        List<String> rows = read(filePath);
        List<List<String>> data = new ArrayList<>();
        for (String row : rows) {
            if (isCorrectString(row, pattern)) {
                data.add(Arrays.stream(row.trim().split(SPLIT_BY)).collect(Collectors.toList()));
            }
        }
        return data;
    }

    @Override
    public void write(List<String> data, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("fruit,quantity\n");
            for (String row : data) {
                writer.write(row + "\n");
            }
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private boolean isCorrectString(String line, String stringPattern) {
        Pattern pattern = Pattern.compile(stringPattern);
        return pattern.matcher(line).matches();
    }
}
