import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.*;

class Solution {

    static class EntryAndExit {

        private LocalTime entryTime;
        private LocalTime exitTime;

        private Long cumulativeParkingTime;

        private Long fee;

        public EntryAndExit() {
            this.entryTime = null;
            this.exitTime = null;
            this.cumulativeParkingTime = 0L;
            this.fee = 0L;
        }

        public LocalTime getEntryTime() {
            return entryTime;
        }

        public void setEntryTime(String entryTime) {
            this.entryTime = LocalTime.parse(entryTime, DateTimeFormatter.ofPattern("HH:mm"));
            this.exitTime = LocalTime.parse("23:59", DateTimeFormatter.ofPattern("HH:mm"));
        }

        public LocalTime getExitTime() {
            return exitTime;
        }

        public void setExitTime(String exitTime) {
//            System.out.println(this);

            this.exitTime = LocalTime.parse(exitTime, DateTimeFormatter.ofPattern("HH:mm"));

            this.cumulativeParkingTime += this.entryTime.until(this.exitTime, ChronoUnit.MINUTES);

            this.entryTime = null;
            this.exitTime = null;
        }

        public Long getCumulativeParkingTime() {
            return cumulativeParkingTime;
        }

        @Override
        public String toString() {
            return "EntryAndExit{" +
                    "entryTime=" + entryTime +
                    ", exitTime=" + exitTime +
                    ", cumulativeParkingTime=" + cumulativeParkingTime +
                    ", fee=" + fee +
                    '}';
        }
    }

    public Long parkingTimeCalculate(int[] fees, EntryAndExit parkingInfo) {
        parkingInfo.fee = (long) fees[1];
        if (parkingInfo.getEntryTime() != null && parkingInfo.getExitTime() != null) {
            parkingInfo.setExitTime("23:59");
        }
        if (parkingInfo.getCumulativeParkingTime() > fees[0]) {
            long unitTime = parkingInfo.getCumulativeParkingTime() - fees[0];
            long extraFee = unitTime / fees[2] * fees[3];
            extraFee += unitTime % fees[2] != 0 ? fees[3] : 0;
            parkingInfo.fee += extraFee;
        }
        return parkingInfo.fee;
    }

    public int[] solution(int[] fees, String[] records) {
        int[] answer;

        HashMap<String, EntryAndExit> carMap = new HashMap<>();

        for (String record : records) {
            String[] splitRecord = record.split(" ");

            if (splitRecord[2].equals("IN")) {
                carMap.putIfAbsent(splitRecord[1], new EntryAndExit());
                carMap.get(splitRecord[1]).setEntryTime(splitRecord[0]);
            }
            else if (splitRecord[2].equals("OUT")) {
                carMap.get(splitRecord[1]).setExitTime(splitRecord[0]);
            }

            System.out.println(splitRecord[1] + ": " + carMap.get(splitRecord[1]));

        }

        System.out.println();

        SortedSet<String> carNumberSet = new TreeSet<>(carMap.keySet());
        System.out.println(carNumberSet);

        answer = new int[carMap.size()];
        int i = 0;
        for (String carNumber : carNumberSet) {
            answer[i++] = Math.toIntExact(parkingTimeCalculate(fees, carMap.get(carNumber)));
            System.out.println(carNumber + ": " + carMap.get(carNumber));
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{180, 5000, 10, 600},
                new String[]{"05:34 5961 IN", "06:00 0000 IN", "06:34 0000 OUT", "07:59 5961 OUT", "07:59 0148 IN", "18:59 0000 IN", "19:09 0148 OUT", "22:59 5961 IN", "23:00 5961 OUT"}
        )));

        System.out.println(Arrays.toString(solution.solution(
                new int[]{120, 0, 60, 591},
                new String[]{"16:00 3961 IN","16:00 0202 IN","18:00 3961 OUT","18:00 0202 OUT","23:58 3961 IN"}
        )));

        System.out.println(Arrays.toString(solution.solution(
                new int[]{1, 461, 1, 10},
                new String[]{"00:00 1234 IN"}
        )));
    }
}