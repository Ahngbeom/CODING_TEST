public class RemoveOneCharacter {
    public String solution(String my_string, String letter) {
        return my_string.replace(letter, "");
    }

    public static void main(String[] args) {
        RemoveOneCharacter removeOneCharacter = new RemoveOneCharacter();

        System.out.println(removeOneCharacter.solution("abcdef", "f"));
        System.out.println(removeOneCharacter.solution("BCBdbe", "B"));
    }
}
