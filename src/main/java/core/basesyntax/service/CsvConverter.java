package core.basesyntax.service;

public class CsvConverter implements Convertable {
    private static final String EXP_HEADER = "type,fruit,quantity";
    private static final String EXP_FORMAT = "b,";

    public String convertCsv(String inputData) {
        String cleanText = inputData.replaceAll(" +", "");
        if (!cleanText.startsWith(EXP_HEADER
                + System.lineSeparator() + EXP_FORMAT)) {
            throw new RuntimeException("Input file must start with: " + System.lineSeparator()
                    + "\"" + EXP_HEADER + "\"" + System.lineSeparator()
                    + "\"" + EXP_FORMAT + "\" for current balance");
        }

        return cleanText;
    }
}
