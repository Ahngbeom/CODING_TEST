package GetReportResults;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SolutionParam {
    public String[] id_list;
    public String[] report;
    public int k;


    public SolutionParam(String[] id_list, String[] report, int k) {
        this.id_list = id_list;
        this.report = report;
        this.k = k;
    }
}

public class Case {
    List<SolutionParam> caseList;

    public Case() {
        this.caseList = new ArrayList<>();
        caseList.add(new SolutionParam(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2
                )
        );
        caseList.add(new SolutionParam(
                        new String[]{"con", "ryan"},
                        new String[]{"ryan con", "ryan con", "ryan con", "ryan con"},
                        3
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "frodo neo", "apeach frodo", "muzi frodo", "frodo neo", "apeach frodo"},
                        1
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "apeach neo", "muzi neo"},
                        1
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"con", "ryan"},
                        new String[]{"con ryan"},
                        5
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"con"},
                        new String[]{"con con"},
                        5
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"muzi", "frodo", "apeach", "neo"},
                        new String[]{"muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi", "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi"},
                        2
                )
        );

        caseList.add(new SolutionParam(
                        new String[]{"muzi", "frodo", "apeach", "neo", "ahng", "beom"},
                        new String[]{
//                                "muzi frodo",
//
//                                "apeach frodo",
//                                "neo frodo",
                                "ahng frodo",
                                "beom frodo",
                                "beom frodo",
                                "ahng neo",
                                "beom neo",
                        },
                        1
                )
        );
    }

    public void all(Solution mainSolution, Solution compareSolution) {
        for (int i = 0; i < caseList.size(); i++) {
            selectCase(mainSolution, compareSolution, i + 1);
        }
//        caseList.forEach(solutionParam -> {
//            System.out.println("solution(" + Arrays.toString(solutionParam.id_list) + ", " + Arrays.toString(solutionParam.report) + "," + solutionParam.k + ")");
//            mainSolution.solution(solutionParam.id_list, solutionParam.report, solutionParam.k);
//            System.out.println();
//            compareSolution.solution(solutionParam.id_list, solutionParam.report, solutionParam.k);
//            System.out.println("===============================================================================");
//        });
    }

    public void selectCase(Solution mainSolution, Solution compareSolution, int caseNumber) {
        SolutionParam solutionParam = caseList.get(caseNumber - 1);
        System.out.println("solution(" + Arrays.toString(solutionParam.id_list) + ", " + Arrays.toString(solutionParam.report) + "," + solutionParam.k + ")");
        mainSolution.solution(solutionParam.id_list, solutionParam.report, solutionParam.k);
        System.out.println();
        compareSolution.solution(solutionParam.id_list, solutionParam.report, solutionParam.k);
        System.out.println("===============================================================================");
    }
}
