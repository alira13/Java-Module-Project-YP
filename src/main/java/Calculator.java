import android.app.VoiceInteractor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Calculator {
    private int PeopleNum;
    private ArrayList<Product> Products;
    private double TotalPrice;
    private double PricePerOne;
    private double Coins;
    public Calculator(){
        Products = new ArrayList<>();
    }

    public void getPeopleNumber(){
        Scanner scanner = new Scanner(System.in);
        String peopleNum;
        do{
            System.out.println("Введите количество человек, которые будут делить счет:");
            peopleNum = scanner.nextLine();
            PeopleNum = Validator.validatePeopleNumber(peopleNum);
        }
        while (PeopleNum==-1);
    }

    public void addProduct(){
        String cancelInput="";
        while(!cancelInput.equalsIgnoreCase("завершить")){
            System.out.println("Добавьте продукт в калькулятор");
            var product = new Product().create();
            Products.add(product);
            System.out.println("Продукт "+ product.show()+" успешно добавлен");
            System.out.println("Хотите добавить еще? Если нет, то напечатайте \"Завершить\"");
            Scanner scanner = new Scanner(System.in);
            cancelInput = scanner.nextLine();
        }
    }

    public void calculate(){
        for (var product:Products) {
            TotalPrice = TotalPrice+product.Price;
        }
        var count=100;
        PricePerOne = (Math.ceil(TotalPrice/PeopleNum*count)/count);
        Coins = Double.parseDouble(String.format(Locale.ENGLISH, "%.2f", PricePerOne*PeopleNum - TotalPrice));
    }

    public void printInputData(){
        System.out.println("Количество человек: "+PeopleNum);
        System.out.println("Добавленные товары:");
        for (var product: Products) {
            System.out.println(product.show());
        }
    }

    public void printResult(){
        System.out.println("Сумма для оплаты на человека " + PricePerOne+ " "+ defineRubleLabel(PricePerOne));
        System.out.println("Сумму поделили поровну, официант принес сдачу " + Coins+ " " + defineRubleLabel(Coins));
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
