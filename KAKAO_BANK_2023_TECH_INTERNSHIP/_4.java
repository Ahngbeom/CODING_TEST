import java.util.*;
import java.util.stream.Collectors;

public class _4 {

    public class Job {
        int requestTime;
        int requireTime;
        int classifyNo;
        int importance;

        public Job(int requestTime, int requireTime, int id, int importance) {
            this.requestTime = requestTime;
            this.requireTime = requireTime;
            this.classifyNo = id;
            this.importance = importance;
        }

        public Job(int[] job) {
            this.requestTime = job[0];
            this.requireTime = job[1];
            this.classifyNo = job[2];
            this.importance = job[3];
        }

//        @Override
//        public String toString() {
//            return "Job{" +
//                    "requestTime=" + requestTime +
//                    ", requireTime=" + requireTime +
//                    ", id=" + id +
//                    ", importance=" + importance +
//                    '}';
//        }


        @Override
        public String toString() {
            return "{" + classifyNo + '}';
        }
    }

    public int[] solution(int[][] jobs) {
        // job: [작업 요청 시각, 작업 처리 소요 시간, 작업 분류 번호, 작업의 중요도]
        // jobs는 요청 시각을 기준으로 오름차순 정렬되어있다.

        int[] answer = {};

        List<Job> jobList = new LinkedList<>();
        List<Job> nextJobList = new ArrayList<>();
        Deque<Job> nextJobDeque = new ArrayDeque<>();

        for (int[] job : jobs) {
            jobList.add(new Job(job));
        }

        int time = jobList.get(0).requestTime;
//        for (int i = 0; i < jobList.size(); i++) {
        for (int i = 0; i < 2; i++) {
            nextJobDeque.peekFirst();
            Job currentJob = jobList.get(i);

            time += currentJob.requireTime;
//            int time = currentJob.requestTime + currentJob.requireTime;

            System.out.println("time: " + time);
            System.out.println("working: " + currentJob);
            System.out.println("current jobs: " + jobList);

//            for (int j = 0; j < jobs.length && jobs[j][0] <= time; j++) {
//                if (jobs[j][0] > currentJob.requestTime) {
//                    if (currentJob.id == jobs[j][2])
//                        jobList.add(i + 1, new Job(jobs[j]));
//                    else
//                        nextJobList.add(new Job(jobs[j]));
//                }
//            }

//            nextJobList.addAll(jobList.subList(i + 1, jobList.size()));


            for (int j = 1; j < jobList.size(); j++) {
                if (jobList.get(j).requestTime <= time) {

                    nextJobDeque.add(jobList.get(j));
//                    if (currentJob.classifyNo == jobList.get(j).classifyNo) {
//                        nextJobDeque.addFirst(jobList.get(j));
//                    }
//                    else
//                        nextJobDeque.addLast(jobList.get(j));
                }
            }

            if (nextJobDeque.size() > 0) {
                nextJobDeque.stream().sorted((o1, o2) -> {
                    if (o1.importance == o2.importance)
                        return o1.classifyNo - o2.classifyNo;
                    else
                        return o2.importance - o1.importance;
                }).collect(Collectors.toSet());
            }

            System.out.println("next jobs: " + nextJobDeque);
//

        }

//        for (int i = 0; i < jobs.length; i++) {
//
//            Job job = new Job(jobs[i]);
//            jobList.add(job);
//
//            for (int j = i + 1; j < jobs.length && jobs[j][0] < job.requestTime + job.requireTime; j++) {
//                nextJobList.add(new Job(jobs[j]));
//            }
//
//            if (nextJobList.size() > 0) {
//                nextJobList.sort((o1, o2) -> {
//                    if (o1.importance == o2.importance)
//                        return o1.id - o2.id;
//                    else
//                        return o2.importance - o1.importance;
//                });
//
//                jobList.addAll(nextJobList);
//                i += nextJobList.size() - 1;
//                nextJobList.clear();
//            }
//
//            System.out.println(jobList);
//
//        }


        return answer;
    }

    public static void main(String[] args) {

        _4 _4 = new _4();

        System.out.println(Arrays.toString(_4.solution(
                new int[][]{
                        {1, 5, 2, 3}, {2, 2, 3, 2}, {3, 1, 3, 3}, {5, 2, 1, 5}, {7, 1, 1, 1}, {9, 1, 1, 1}, {10, 2, 2, 9}
                }
        )));
    }
}
