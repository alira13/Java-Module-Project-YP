import java.util.Locale;
import java.util.Scanner;

public class Product {
    public String name;
    public double price;

    public Product create(){
        addName();
        addPrice();
        return this;
    }

    public void addName(){
        System.out.println("Введите название продукта:");
        Scanner in = new Scanner(System.in);
        name = in.nextLine();
    }

    public void addPrice(){
        Scanner in = new Scanner(System.in);
        String priceAsString;
        do{
            System.out.println("Введите цену продукта:");
            priceAsString = in.nextLine();
            this.price = Validator.validateProductPrice(priceAsString);
        }
        while(this.price ==-1);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s %.2f  руб.", name, price);
    }
}
