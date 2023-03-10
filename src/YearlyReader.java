import java.util.ArrayList;
import java.util.List;

public class YearlyReader {
    FileReader fileReader = new FileReader();   // Читатель csv
    ArrayList<YearLine> yearStat = new ArrayList<>();
    public YearlyReader(String path) {
        List<String> lines = fileReader.readFileContents(path); // Читаем csv, разделяет на строки
        for (int i = 1; i < lines.size(); i++) {   // Перебираем каждую строку
            String line = lines.get(i);
            String[] parts = line.split(",");   // Каждую строку csv добавляет в объект
            String monthNum = parts[0];
            Double amount = Double.parseDouble(parts[1]);
            Boolean isExpense = Boolean.parseBoolean(parts[2]);
            YearLine stat = new YearLine(monthNum, amount, isExpense);
            yearStat.add(stat);
        }
    }
}