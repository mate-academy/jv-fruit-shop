package core.basesyntax;

import core.basesyntax.dao.DataConverter;
import core.basesyntax.impl.DataConverterImpl;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileRider {
    private final DataConverter dataConverter;

    public FileRider() {
        this.dataConverter = new DataConverterImpl();
    }

    public List<FruitTransaction> readTransactions(String filePath) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;

            while ((line = br.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return dataConverter.convertToTransaction(lines);
    }
}
