public class Validator {
    public static int validatePeopleNumber(String peopleNumAsString){
        try {
            int peopleNum = Integer.parseInt(peopleNumAsString);
            if (peopleNum <= 1) {
                System.out.println("ОШИБКА! Количество человек должно быть больше 1");
                return -1;
            }
            return peopleNum;
        }
        catch (Exception ex){
            System.out.println("ОШИБКА! Количество человек должно быть целым числом");
            return -1;
        }
    }

    public static double validateProductPrice(String priceAsString){
        try {
            String priceWithDot = priceAsString.replace(',', '.');
            var price = Double.parseDouble(priceWithDot);
            if (price == 0) {
                System.out.println("ОШИБКА! Цена не может быть 0");
                return -1;
            }
            return price;
        }
        catch (Exception ex){
            System.out.println("ОШИБКА! Цена продукта должна быть введена в формате 0 рублей.00 копеек");
            return -1;
        }
    }
}
