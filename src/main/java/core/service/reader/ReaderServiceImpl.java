package core.service.reader;

import core.service.validator.FirstLineValidatorImpl;
import core.service.validator.FollowingLineValidatorImpl;
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
    private FollowingLineValidatorImpl followingLineValidator;

    public ReaderServiceImpl() {
        listFromInputFile = new ArrayList<>();
        firstLineValidator = new FirstLineValidatorImpl();
        followingLineValidator = new FollowingLineValidatorImpl();
    }

    @Override
    public List<String> read(String filePath) {
        File file = new File(filePath);
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
