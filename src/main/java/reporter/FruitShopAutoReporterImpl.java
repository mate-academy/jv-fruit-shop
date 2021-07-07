package reporter;

import db.FruitsDao;
import db.GenericDao;
import java.io.File;
import java.nio.file.Path;
import java.util.List;
import parser.FruitShopDataParser;
import parser.Parser;
import reader.FileReaderImpl;
import service.ProcessFruitsMapToString;
import writer.Writer;
import writer.WriterToFileImpl;

public class FruitShopAutoReporterImpl implements Reporter<Path, GenericDao> {
    @Override
    public void makeReportFromTo(Path pathFrom, Path pathTo, GenericDao dao) {
        GenericDao fruitsDao = dao;
        List<String> data = new FileReaderImpl().read(pathFrom);
        Parser<List<String>> dataParser = new FruitShopDataParser(fruitsDao);
        dataParser.parse(data);
        File file = pathTo.toFile();
        String report = new StringBuilder("fruit, quantity")
                .append(new ProcessFruitsMapToString()
                        .process(fruitsDao.getAll()))
                .toString();
        Writer<File, String> writer = new WriterToFileImpl();
        writer.write(file, report);
    }
}
