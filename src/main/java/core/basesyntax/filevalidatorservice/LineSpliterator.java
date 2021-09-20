package core.basesyntax.filevalidatorservice;

public class LineSpliterator implements Validator {
    public String[] splitLineToArray(String line) {
        String[] split = line.split(CSV_SEPARATOR);
        if (split.length < 3) {
            throw new RuntimeException("Incorrect entry in file. Missing entry");
        }
        for (String value : split) {
            if (value.equals("")) {
                throw new RuntimeException("Incorrect entry in file. Missing entry");
            }
        }
        return split;
    }
}
