package core.basesyntax.Dao;

import core.basesyntax.model.Product;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PivotDaoImpl implements PivotDao {
    @Override
    public void writePivotFile(String fileName, List<String> stringList) {
        Path filePath = Path.of(fileName);
        String header = "product,quantity";
        try (FileWriter fileWriter = new FileWriter(filePath.toFile());
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.printf(header + System.lineSeparator());
            for (String str : stringList) {
                printWriter.printf(str + System.lineSeparator());
            }
        } catch (IOException e) {
            throw new RuntimeException("Can't write to file " + fileName, e);
        }
    }

    @Override
    public List<String> getBalanceList(Map<Product, Integer> balanceByProduct) {
        return balanceByProduct.entrySet().stream()
                .map(p -> (p.getKey().getType() + "," + p.getValue()))
                .collect(Collectors.toList());
    }

}
