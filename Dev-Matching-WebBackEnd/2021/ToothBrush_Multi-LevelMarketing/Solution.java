import java.util.*;

class Solution {

    LinkedHashMap<String, MemberInfo> members = new LinkedHashMap<>();

    class MemberInfo {
        private String recommendedMe;
        private Set<String> recommendedMemberList;
        private Long profit;

        public MemberInfo(String recommendedMe) {
            this.recommendedMe = recommendedMe.equals("-") ? null : recommendedMe;
            this.recommendedMemberList = new HashSet<>();
            this.profit = 0L;
        }

        public Set<String> getRecommendedMemberList() {
            return recommendedMemberList;
        }


        public Long getProfit() {
            return profit;
        }

        public void addProfit(Long profit) {
            if (this.recommendedMe != null && profit / 10L >= 1L) {
                members.get(this.recommendedMe).addProfit(profit / 10L);
            }
            profit = profit - (profit / 10L);
            this.profit += profit;
        }

        @Override
        public String toString() {
            return "MemberInfo{" +
                    "recommendedMe='" + recommendedMe + '\'' +
                    ", recommendedMemberList=" + recommendedMemberList +
                    ", profit=" + profit +
                    '}';
        }
    }

    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        int[] answer;

//        LinkedHashMap<String, MemberInfo> members = new LinkedHashMap<>();

        for (int i = 0; i < enroll.length; i++) {
            members.put(enroll[i], new MemberInfo(referral[i]));
            if (members.containsKey(referral[i]))
                members.get(referral[i]).getRecommendedMemberList().add(enroll[i]);
        }

        for (int i = 0; i < seller.length; i++) {
            MemberInfo memberInfo = members.get(seller[i]);
            memberInfo.addProfit(100L * amount[i]);

//            members.forEach((name, info) -> {
//                System.out.printf("%-10s: %s\n", name, info);
//            });
//            System.out.println("--------------------------------------------------------------------------------");
        }

//        members.forEach((name, info) -> {
//            System.out.printf("%-10s: %s\n", name, info);
//        });
//        System.out.println("--------------------------------------------------------------------------------");

        answer = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            answer[i] = Math.toIntExact(members.get(enroll[i]).getProfit());
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(Arrays.toString(solution.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"young", "john", "tod", "emily", "mary"},
                new int[]{12, 4, 2, 5, 10}
        )));

        System.out.println(Arrays.toString(solution.solution(
                new String[]{"john", "mary", "edward", "sam", "emily", "jaimie", "tod", "young"},
                new String[]{"-", "-", "mary", "edward", "mary", "mary", "jaimie", "edward"},
                new String[]{"sam", "emily", "jaimie", "edward"},
                new int[]{2, 3, 5, 4}
        )));

    }
}