package core.basesyntax;

import java.nio.file.Path;
import java.util.List;
import servise.calculate.CalculateFruits;
import servise.calculate.CalculateFruitsImp;
import servise.convertobject.ConvertToObject;
import servise.convertobject.ConvertToObjectImp;
import servise.readfromfile.ReadFromFile;
import servise.readfromfile.ReadFromFileImpl;
import servise.report.Report;
import servise.report.ReportImp;
import servise.writefromfile.WriteToFile;
import servise.writefromfile.WriteToFileImp;

public class Main {
    public static void main(String[] args) {

        Path path = Path.of("inputData.csv");
        Path pathReport = Path.of("report.csv");

        ReadFromFile readFromFile = new ReadFromFileImpl();
        List<String> inputFromFile = readFromFile.readFromFile(path);

        ConvertToObject convertToObject = new ConvertToObjectImp();
        List<String> keysForStorage = convertToObject.convertToObject(inputFromFile);

        CalculateFruits calculateFruits = new CalculateFruitsImp();
        calculateFruits.calculateFruits(keysForStorage);

        Report report = new ReportImp();
        String reportString = report.report(keysForStorage);

        WriteToFile writeToFile = new WriteToFileImp();
        writeToFile.writeToFile(pathReport, reportString);
    }
}
