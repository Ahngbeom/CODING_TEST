public class Age_of_Exoplanet {
    public String solution(int age) {
        StringBuilder answer = new StringBuilder();
        while (age > 0) {
            answer.insert(0, Character.toChars('a' + age % 10));
            age /= 10;
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Age_of_Exoplanet age_of_exoplanet = new Age_of_Exoplanet();
        System.out.println(age_of_exoplanet.solution(23));
        System.out.println(age_of_exoplanet.solution(51));
        System.out.println(age_of_exoplanet.solution(100));
    }
}
