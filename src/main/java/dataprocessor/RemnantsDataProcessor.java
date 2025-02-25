package dataprocessor;

import java.util.LinkedList;
import java.util.List;

public class RemnantsDataProcessor implements DataProcessor {
    @Override
    public List<String[]> processData(List<String[]> records) {
        String[] strings = records.remove(0);
        List<String[]> retList = new LinkedList<>();
        int typeColIndex = 0;
        int goodColIndex = 1;
        int qnttColIndex = 2;
        for (int i = 0; i < strings.length; i++) {
            switch (strings[i]) {
                case "type":
                    typeColIndex = i;
                    break;
                case "fruit":
                    goodColIndex = i;
                    break;
                case "quantity":
                    qnttColIndex = i;
                    break;
                default:
                    throw new RuntimeException("There is undefined column in data!!!!"
                            + " Data processing stopped until it fixed!!!!");
            }
        }
        for (String[] record : records) {
            if (record[typeColIndex].equals(ProcessAnchors.p.toString())) {
                retList.add(new String[] {record[goodColIndex],
                        (Integer.parseInt(record[qnttColIndex]) * -1) + ""});
            } else {
                retList.add(new String[] {record[goodColIndex],
                        Integer.parseInt(record[qnttColIndex]) + ""});
            }
        }
        return retList;
    }

    public enum ProcessAnchors {
        b, // - balance, the remnants of fruits at the beginning of the working day
        s, // - supply, means you are receiving new fruits from suppliers
        p, // - purchase, means someone has bought some fruit
        r // - return, means someone who has bought the fruits now returns them back
    }
}
