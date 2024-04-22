package exception;

import java.util.Arrays;

public class CheckSplitLineImpl implements CheckSplitLine {
    private static final String SPECIAL_CHARACTER = ",";
    private static final int VALUE_INDEX = 2;

    public String[] checkAndGetLine(String line) {
        String[] splitLine = line.split(SPECIAL_CHARACTER);
        if (splitLine.length != 3) {
            throw new IndexOutOfBoundsException(Arrays.toString(splitLine) + " length don't equals 3");
        }
        if (Integer.parseInt(splitLine[VALUE_INDEX]) <= 0) {
            throw new IndexOutOfBoundsException("value " + splitLine[VALUE_INDEX] + " less then 0");
        }
        return splitLine;
    }
}
