public class MonthLine {     // Объект этого класса -- это информация об одном товаре месяца.
    String itemName;
    Boolean isExpense;
    Integer quantity;
    Double sumOfOne;

    public MonthLine(String itemName, Boolean isExpense, Integer quantity, Double sumOfOne) {
        this.itemName = itemName;
        this.isExpense = isExpense;
        this.quantity = quantity;
        this.sumOfOne = sumOfOne;
    }
}
