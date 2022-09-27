import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class PhoneBookList {

    // Accuracy: 83.3
    // Efficiency: 8.3
    // Total: 91.7 / 100
    public boolean solution1(String[] phone_book) {
        Arrays.sort(phone_book);
        System.out.println(Arrays.toString(phone_book));
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }
        return true;
    }

    // Accuracy: 83.3
    // Efficiency: 8.3
    // Total: 91.7 / 100
    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book, Comparator.comparingInt(String::length));
        System.out.println(Arrays.toString(phone_book));
        for (int i = 0; i < phone_book.length - 1; i++) {
            for (int j = i + 1; j < phone_book.length; j++) {
                if (phone_book[j].startsWith(phone_book[i]))
                    return false;
            }
        }
        return true;
    }

    // Accuracy: 83.3
    // Efficiency: 16.7
    // Total: 100 / 100
    public boolean solution3(String[] phone_book) {
        HashMap<String, ?> phoneBookMap = new HashMap<>();

        for (String number : phone_book) {
            phoneBookMap.put(number, null);
        }

        for (String number : phone_book) {
            for (int i = 1; i < number.length(); i++) {
                if (phoneBookMap.containsKey(number.substring(0, i)))
                    return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PhoneBookList phoneBookList = new PhoneBookList();

        System.out.println(phoneBookList.solution3(
                new String[]{"119", "97674223", "1195524421"}
        ));

        System.out.println(phoneBookList.solution3(
                new String[]{"123","456","789"}
        ));

        System.out.println(phoneBookList.solution3(
                new String[]{"12","123","1235","567","88"}
        ));
    }
}
