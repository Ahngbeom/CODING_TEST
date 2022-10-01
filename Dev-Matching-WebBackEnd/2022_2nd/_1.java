
import java.util.List;

public class _1 {

    public String stringExtract(String id) {
        int i;
        for (i = 0; i < id.length(); i++){
            if (id.charAt(i) >= '0' && id.charAt(i) <= '9')
                break;
        }
        return id.substring(0, i);
    }

    public Integer numberExtract(String id) {
        int i;
        for (i = 0; i < id.length(); i++){
            if (id.charAt(i) >= '0' && id.charAt(i) <= '9')
                break;
        }
        if (i == id.length())
            return 0;
        return Integer.parseInt(id.substring(i));
    }

    public String solution(String[] registered_list, String new_id) {
        List<String> registeredList = List.of(registered_list);

        while (registeredList.contains(new_id)) {
            new_id = stringExtract(new_id) + (numberExtract(new_id) + 1);
        }
        return new_id;
    }

    public static void main(String[] args) {
        _1 _1 = new _1();


        System.out.println(_1.solution(
                new String[]{"cow", "cow1", "cow2", "cow3", "cow4"},
                "cow"
        ));

    }
}
