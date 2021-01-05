package fshop.service.workfile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class ReadCsvImpl implements ReadCsv {
    private static final String COMA = ",";
    private String fileName;

    public ReadCsvImpl(String fileName) {
        Objects.requireNonNull(fileName);
        this.fileName = fileName;
    }

    @Override
    // set parameter
    public List<String> read() {
        try {
            return checkToNegativeAfterRead(Files
                    .readAllLines(Paths.get(new File(fileName)
                            .getAbsolutePath())));
        } catch (IOException e) {
            throw new RuntimeException("Can't read the file!");
        }
    }

    private List<String> checkToNegativeAfterRead(List<String> listAfterRead) {
        listAfterRead.remove(0);
        Iterator<String> stringIterator = listAfterRead.iterator();
        while (stringIterator.hasNext()) {
            String searchNegativeValue = stringIterator.next();
            if (Integer.parseInt(searchNegativeValue
                    .substring(searchNegativeValue.lastIndexOf(COMA) + 1)) < 0) {
                throw new IllegalArgumentException("Value is negative!");
            }
        }
        return listAfterRead;
    }
}
