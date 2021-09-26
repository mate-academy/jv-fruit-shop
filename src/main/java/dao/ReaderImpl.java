package dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import validator.Validator;
import validator.ValidatorImpl;

public class ReaderImpl implements Reader {
    private static final Validator validator = new ValidatorImpl();

    @Override
    public List<String> reader(String fileName) {
        List<String> result = new ArrayList<>();
        try (BufferedReader csvReader = new BufferedReader(new FileReader(fileName))) {
            csvReader.readLine();
            String row;
            while ((row = csvReader.readLine()) != null) {
                validator.validate(row);
                result.add(row);
            }
        } catch (IOException e) {
            throw new RuntimeException("Unable to read file");
        }
        return result;
    }
}
