import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private int peopleNum;
    private ArrayList<Product> products;
    private double totalPrice;
    private double pricePerOne;
    private double coins;
    public Calculator(){
        products = new ArrayList<>();
    }

    public void getPeopleNumber(){
        Scanner scanner = new Scanner(System.in);
        String peopleNum;
        do{
            System.out.println("Введите количество человек, которые будут делить счет:");
            peopleNum = scanner.nextLine();
            this.peopleNum = Validator.validatePeopleNumber(peopleNum);
        }
        while (this.peopleNum ==-1);
    }

    public void addProduct(){
        String cancelInput="";
        while(!cancelInput.equalsIgnoreCase("завершить")){
            System.out.println("Добавьте продукт в калькулятор");
            var product = new Product().create();
            products.add(product);
            System.out.println("Продукт "+ product+" успешно добавлен");
            System.out.println("Хотите добавить еще? Если нет, то напечатайте \"Завершить\"");
            Scanner scanner = new Scanner(System.in);
            cancelInput = scanner.nextLine();
        }
    }

    public void calculate(){
        for (var product: products) {
            totalPrice = totalPrice +product.price;
        }
        var count=100;
        pricePerOne = (Math.ceil(totalPrice / peopleNum *count)/count);
        coins = Double.parseDouble(String.format(Locale.ENGLISH, "%.2f", pricePerOne * peopleNum - totalPrice));
    }

    public void printInputData(){
        System.out.println("Количество человек: "+ peopleNum);
        System.out.println("Добавленные товары:");
        for (var product: products) {
            System.out.println(product);
        }
    }

    public void printResult(){
        System.out.println("Сумма для оплаты на человека " + pricePerOne + " "+ defineRubleLabel(pricePerOne));
        System.out.println("Сумму поделили поровну, официант принес сдачу " + coins + " " + defineRubleLabel(coins));
    }

    public String defineRubleLabel(double rubles){
        BigDecimal bigDecimal = new BigDecimal(String.valueOf(rubles));
        String rublesLabel;
        int totalRubles = bigDecimal.intValue();
        if (totalRubles % 100 >= 11 & totalRubles % 100 <= 20){
            rublesLabel="рублей";
            return rublesLabel;
        }
        switch (totalRubles%10){
            case 1: rublesLabel="рубль"; break;
            case 2:
            case 3:
            case 4: rublesLabel="рубля"; break;
            default: rublesLabel="рублей"; break;
        }
        return rublesLabel;
    }
}
