public class YearLine {     // Объект этого класса -- это информация о выручке месяца.
    String month;
    Double amount;
    Boolean isExpense;

    public YearLine(String month, Double amount, Boolean isExpense) {
        this.month = month;
        this.amount = amount;
        this.isExpense = isExpense;
    }
}
