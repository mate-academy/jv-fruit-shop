package core.basesyntax.service;

import java.io.BufferedReader;
import java.io.IOException;

public class CSvReader extends FileReader {
    private static final String EXP_HEADER = "type,fruit,quantity";
    private static final String EXP_FORMAT = "b,";

    @Override
    public String readFile(String fromFileName) {
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(fromFileName))) {
            StringBuilder data = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                data.append(line).append(System.lineSeparator());
            }
            System.out.println(data.toString().replaceAll(" +", ""));
            if (!data.toString().replaceAll(" +", "").startsWith(EXP_HEADER
                    + System.lineSeparator() + EXP_FORMAT)) {
                throw new RuntimeException("Input file must start with: " + System.lineSeparator()
                                + "\"" + EXP_HEADER + "\"" + System.lineSeparator()
                                + "\"" + EXP_FORMAT + "\" for current balance");
            }
            return data.toString().replaceAll(" +", "");
        } catch (IOException e) {
            throw new RuntimeException("Error reading from file", e);
        }
    }
}
