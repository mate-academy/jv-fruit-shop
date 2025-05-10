package service.impl;

import java.util.Arrays;

public class LineSplitterImpl {
    private static final String COMMA = ",";
    private static final int VALUE_INDEX = 2;

    public String[] splitLine(String line) {
        String[] splitLine = line.split(COMMA);
        if (splitLine.length != 3) {
            throw new IndexOutOfBoundsException(Arrays.toString(splitLine)
                    + " length don't equals 3");
        }
        if (Integer.parseInt(splitLine[VALUE_INDEX]) <= 0) {
            throw new IndexOutOfBoundsException("value " + splitLine[VALUE_INDEX]
                    + " less then 0");
        }
        return splitLine;
    }
}
