package core.basesyntax.filevalidatorservice;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileValidatorImpl implements FileValidator {
    private LineValidatorImpl validator = new LineValidatorImpl();
    private LineSpliterator lineSpliterator = new LineSpliterator();

    @Override
    public boolean validateFile(String path) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            String line = bufferedReader.readLine();
            if (!line.equals(TOPLINE)) {
                throw new RuntimeException("Cannot validate file");
            }
            line = bufferedReader.readLine();
            while (line != null) {
                String[] temporary = lineSpliterator.splitLineToArray(line);
                if (!validator.lineValidator(temporary)) {
                    throw new RuntimeException("Cannot validate file");
                }
                line = bufferedReader.readLine();
            }
        } catch (IOException e) {
            throw new RuntimeException("Cannot validate file");
        }
        return true;
    }
}

