import java.util.Locale;
import java.util.Scanner;

public class Product {
    public String Name;
    public double Price;

    public Product create(){
        addName();
        addPrice();
        return this;
    }

    public void addName(){
        System.out.println("Введите название продукта:");
        Scanner in = new Scanner(System.in);
        Name = in.nextLine();
    }

    public void addPrice(){
        Scanner in = new Scanner(System.in);
        String priceAsString;
        double price;
        do{
            System.out.println("Введите цену продукта:");
            priceAsString = in.nextLine();
            Price = Validator.validateProductPrice(priceAsString);
        }
        while(Price==-1);
    }

    public String show() {
        return String.format(Locale.ENGLISH, "%s %.2f  руб.", Name, Price);
    }
}
