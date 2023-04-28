import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            var calculator = new Calculator();
            calculator.getPeopleNumber();
            calculator.addProduct();
            calculator.printInputData();
            calculator.calculate();
            calculator.printResult();
        } catch (Exception ex) {
            System.out.println("ОШИБКА! В процессе работы приложения что-то пошло не так");
        }
    }
}