package core.basesyntax.service;

import core.basesyntax.service.Operation.OperationHandler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

public class ShopServiceStrategy {
    private Map<Operation, OperationHandler> OpHandlerMap;

    public enum Operation {
        BALANCE("b"),
        SUPPLY("s"),
        PURCHASE("p"),
        RETURN("r");

        private String code;

        Operation(String code) {
            this.code = code;
        }

        public String getCode() {
            return code;
        }
    }

    public ShopServiceStrategy(Map<Operation, OperationHandler> OpHandlerMap) {
        this.OpHandlerMap = OpHandlerMap;
    }

    public OperationHandler get(Operation type) {
        return OpHandlerMap.get(type);
    }

    public void acceptFile(String fromFileName) {
        String dataFromFile = readFile(fromFileName);
        handleStatistics(dataFromFile);
    }

    private String readFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fromFileName))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("type,fruit,")) {
                    continue;
                }
                data.append(line).append(System.lineSeparator());
            }
            return data.toString().trim();
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }

    private void handleStatistics(String dataFromFile) {
       // String[] lines = dataFromFile.split(System.lineSeparator());
        //for (String line : lines) {
        //            String[] values = line.split(",");
        //            int amount = Integer.parseInt(values[1]);
        Arrays.stream(dataFromFile.split(System.lineSeparator()))
                .map(line -> line.split(","))
                .forEach(values -> {
            if (Objects.equals(values[0], Operation.SUPPLY.getCode())) {
                get(Operation.SUPPLY).handle(values[1], Integer.parseInt(values[2]));
            }

            if (Objects.equals(values[0], Operation.PURCHASE.getCode())) {
                get(Operation.PURCHASE).handle(values[1], Integer.parseInt(values[2]));
            }

            if (Objects.equals(values[0], Operation.RETURN.getCode())) {
                get(Operation.RETURN).handle(values[1], Integer.parseInt(values[2]));
            }

            if (Objects.equals(values[0], Operation.BALANCE.getCode())) {
                get(Operation.BALANCE).handle(values[1], Integer.parseInt(values[2]));
            }
        });
    }
}
