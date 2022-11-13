import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class _3 {

    public boolean[] openRoomByMasterKey(int[] rooms, List<Integer> masterKeys) {
        boolean[] result = new boolean[rooms.length];

        Set<Integer> getKeys = new HashSet<>();
        for (int masterKey : masterKeys) {
            result[masterKey - 1] = true;
            getKeys.add(rooms[masterKey - 1]);
        }
        for (Integer key: getKeys) {
            result[key - 1] = true;
        }
        return result;
    }

    public boolean isOpenedAll(boolean[] roomsState) {
        for (boolean status: roomsState) {
            if (!status)
                return false;
        }
        return true;
    }

    public int solution(int[] rooms) {

        if (rooms.length == 1)
            return 1;

        int haveOwnKeyRoomCount = 0;
        int doNotHaveOwnKeyRoomCount = 0;

        List<Integer> haveOwnKeyRooms = new ArrayList<>();
        List<Integer> doNotHaveOwnKeyRooms = new ArrayList<>();

        for (int i = 0; i < rooms.length; i++) {
            if (i + 1 == rooms[i]) {
                haveOwnKeyRoomCount++;
                haveOwnKeyRooms.add(i + 1);
            }
            else {
                doNotHaveOwnKeyRoomCount++;
                doNotHaveOwnKeyRooms.add(i + 1);
            }
        }



        if (haveOwnKeyRoomCount == rooms.length)
            return rooms.length - 1;

        if (haveOwnKeyRoomCount == doNotHaveOwnKeyRoomCount)
            return haveOwnKeyRoomCount;

        if (haveOwnKeyRoomCount > 0) {
            if (doNotHaveOwnKeyRoomCount > haveOwnKeyRoomCount && !isOpenedAll(openRoomByMasterKey(rooms, haveOwnKeyRooms))) {
                return haveOwnKeyRoomCount + 1;
            }
            else
                return haveOwnKeyRoomCount;
        }

        return 1;
    }

    public static void main(String[] args) {
        _3 _3 = new _3();

        System.out.println(_3.solution(new int[]{3, 1, 2, 4}));
        System.out.println(_3.solution(new int[]{2, 3, 4, 5, 1}));
        System.out.println(_3.solution(new int[]{1, 2, 3, 4, 5, 6}));

        System.out.println();

//        System.out.println(_3.solution(new int[]{3, 2, 1, 4}));
//        System.out.println(_3.solution(new int[]{2, 3, 4, 1}));
//        System.out.println(_3.solution(new int[]{3, 2, 1, 4, 5}));
//        System.out.println(_3.solution(new int[]{1, 2, 3}));
//        System.out.println(_3.solution(new int[]{2, 1, 3}));
//        System.out.println(_3.solution(new int[]{1}));
//        System.out.println(_3.solution(new int[]{2, 1}));
        System.out.println(_3.solution(new int[]{6, 2, 3, 4, 5, 1})); // 4 2
        System.out.println(_3.solution(new int[]{6, 2, 3, 4, 1, 5})); // 3 3
        System.out.println(_3.solution(new int[]{1, 2, 4, 5, 6, 3})); // 2 4
        System.out.println(_3.solution(new int[]{6, 2, 3, 5, 4, 1})); // 2 4
    }
}
