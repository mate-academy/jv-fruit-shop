package core.service.reader;

import core.service.validator.FirstLineValidatorImpl;
import core.service.validator.LineValidatorImpl;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderServiceImpl implements ReaderService {
    private List<String> listFromInputFile;
    private FirstLineValidatorImpl firstLineValidator;
    private LineValidatorImpl followingLineValidator;

    public ReaderServiceImpl() {
        listFromInputFile = new ArrayList<>();
        firstLineValidator = new FirstLineValidatorImpl();
        followingLineValidator = new LineValidatorImpl();
    }

    @Override
    public List<String> read(String inputFilePath) {
        File file = new File(inputFilePath);
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
            String tmp = bufferedReader.readLine();
            firstLineValidator.valid(tmp);
            while (null != (tmp = bufferedReader.readLine())) {
                followingLineValidator.valid(tmp);
                listFromInputFile.add(tmp);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File wasn't be found!");
        } catch (IOException e) {
            throw new RuntimeException("File wasn't be read!");
        }
        return listFromInputFile;
    }
}
