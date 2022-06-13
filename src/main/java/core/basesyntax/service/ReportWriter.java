package core.basesyntax.service;

import java.util.ArrayList;
import java.util.List;

public class ReportWriter {
    public List<String[]> report = new ArrayList<>();

    public void writeHead(){
        report.add(new String[]{"fruit", "quantity"});
    }

    public void writeLine(String fruit, Integer amount){
        report.add(new String[]{fruit, String.valueOf(amount)});
    }
}
