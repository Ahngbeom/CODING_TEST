import java.util.*;

public class NotFinishedPlayer {

    // Accuracy: 50 / 50
    // Efficiency: 0 / 50
    public String solution1(String[] participant, String[] completion) {

        List<String> participantList = new ArrayList<>(Arrays.asList(participant));

        for (String s : completion) {
            participantList.remove(s);
        }

        return participantList.get(0);
    }

    // Accuracy: 50 / 50
    // Efficiency: 50 / 50
    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i]))
                return participant[i];
        }

        return participant[participant.length - 1];
    }

    public String solution3(String[] participant, String[] completion) {
        HashMap<String, Boolean> completionMap = new LinkedHashMap<>();

        for (String completionPlayer : completion) {
            completionMap.putIfAbsent(completionPlayer, true);
        }

        for (String player : participant) {
            Boolean state = completionMap.putIfAbsent(player, false);
            if (state != null)
                completionMap.replace(player, !state);
        }

        completionMap.forEach((player, complete) -> {
            System.out.println(player + ": " + complete);
        });

        for (String player : participant) {
            if (!completionMap.containsKey(player) || !completionMap.get(player))
                return player;
        }
        return null;
    }

    public static void main(String[] args) {
        NotFinishedPlayer notFinishedPlayer = new NotFinishedPlayer();

        System.out.println(notFinishedPlayer.solution3(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}
        ));

        System.out.println(notFinishedPlayer.solution3(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}
        ));

        System.out.println(notFinishedPlayer.solution3(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}
        ));

    }
}
