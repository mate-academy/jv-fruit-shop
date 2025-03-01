package core.basesyntax.dataprocessor;

import java.util.LinkedList;
import java.util.List;

public class RemnantsDataProcessor implements DataProcessor {
    private static final String HEADER_TYPE = "type";
    private static final String HEADER_CATEGORY = "fruit";
    private static final String HEADER_QUANTITY = "quantity";

    @Override
    public List<String[]> processData(List<String[]> records) {
        String[] strings = records.remove(0);
        List<String[]> retList = new LinkedList<>();
        int typeColIndex = 0;
        int goodColIndex = 1;
        int qnttColIndex = 2;
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case HEADER_TYPE:
                    typeColIndex = i;
                    break;
                case HEADER_CATEGORY:
                    goodColIndex = i;
                    break;
                case HEADER_QUANTITY:
                    qnttColIndex = i;
                    break;
                default:
                    throw new RuntimeException("There is undefined column in data!!!!"
                            + " Data processing stopped until it fixed!!!!");
            }
        }
        for (String[] record : records) {
            if (record[typeColIndex].equals(ProcessAnchors.p.toString())) {
                retList.add(new String[]{record[goodColIndex],
                        (Integer.parseInt(record[qnttColIndex]) * -1) + ""});
            } else {
                retList.add(new String[]{record[goodColIndex],
                        Integer.parseInt(record[qnttColIndex]) + ""});
            }
        }
        return retList;
    }

    public enum ProcessAnchors {
        b,
        s,
        p,
        r
    }
}
