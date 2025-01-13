package core.basesyntax.model;

import core.basesyntax.service.ProductDao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProductDaoCsvImpl implements ProductDao {
    private final String sourceFilePath;

    public ProductDaoCsvImpl(String sourceFilePath) {
        this.sourceFilePath = sourceFilePath;
    }

    @Override
    public List<String> getAll() {
        List<String> transactions = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(sourceFilePath))) {
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                transactions.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException("Error reading file: " + sourceFilePath, e);
        }
        return transactions;
    }
}
