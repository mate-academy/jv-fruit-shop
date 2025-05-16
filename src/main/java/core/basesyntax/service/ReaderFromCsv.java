package core.basesyntax.service;

import core.basesyntax.model.Operation;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class ReaderFromCsv {
    public void processTransactions(String filePath, ShopService shopService) {
        try {
            List<String> lines = Files.readAllLines(Path.of(filePath));
            lines.remove(0); // Пропускаємо заголовок

            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length != 3) {
                    continue;
                }
                Operation operation = parseOperation(parts[0]);
                String fruit = parts[1].trim();
                BigDecimal quantity = new BigDecimal(parts[2].trim());
                shopService.transfer(operation, fruit, quantity);
            }
        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + filePath, e);
        }
    }

    private Operation parseOperation(String code) {
        return switch (code.trim()) {
            case "b" -> Operation.BALANCE;
            case "s" -> Operation.SUPPLY;
            case "p" -> Operation.PURCHASE;
            case "r" -> Operation.RETURN;
            default -> throw new IllegalArgumentException("Unknown operation: " + code);
        };
    }
}
