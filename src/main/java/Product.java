import java.util.Locale;
import java.util.Scanner;

public class Product {
    public String name;
    public double price;
    private Scanner scanner;

    public Product create() {
        scanner = new Scanner(System.in);
        addName();
        addPrice();
        return this;
    }

    public void addName() {
        System.out.println("Введите название продукта:");
        name = scanner.nextLine();
    }

    public void addPrice() {
        String priceAsString;
        do {
            System.out.println("Введите цену продукта:");
            priceAsString = scanner.nextLine();
            this.price = Validator.validateProductPrice(priceAsString);
        }
        while (this.price == -1);
    }

    public String toString() {
        return String.format(Locale.ENGLISH, "%s %.2f  руб.", name, price);
    }
}
