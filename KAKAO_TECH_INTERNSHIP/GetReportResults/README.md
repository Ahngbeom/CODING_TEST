# https://school.programmers.co.kr/learn/courses/30/lessons/92334

# Memoirs

### # 첫번째 시도
    ...

### # 두번째 시도
    ...

### # 세번째 시도

이외에 테스트 케이스를 아무리 생각해봐도 더 나오지않고 해결책이 떠오르지 않아 통과한 자들의 블로그 및 코드를 살펴보기로 했다.  

대부분의 블로그에서 이 문제의 핵심은 중복을 제거하는 것이라고 적혀있다. \
<span style="color:yellow">*나도 알고있다.*</span>

코드를 살펴보니 Set 객체를 활용하여 중복을 제거하는 모습이 많이 보였다. \
<span style="color:yellow">*나도 그러하였다.*</span>

<span style="color:red">**그렇다면 무엇이 문제였을까?**</span>
 - 첫번째와 두번째 시도의 실행 결과에서는 시간 초과는 발생하지 않았다. 

 - 세번째 시도와 나머지 시도들의 중간 결과를 비교해보면 차이가 없다.\
(최소 내가 만든 테스트 케이스에서는...)

 - 세번째 시도의 특징은 `LinkedHashMap` 객체에 데이터를 삽입하기 전 `report` 배열안의 중복된 문자열들을 제거하는 과정이 추가되었다는 점이다.


| **#** | Try 1                                | Try 2                                                                                                                                                                                                                                                                                           | Try3                                                                                                             |
|:-----:|:-------------------------------------|:------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|:-----------------------------------------------------------------------------------------------------------------|
|   1   | `id_list`의 원소 개수만큼 `answer` 배열 공간 확보 | `id_list`의 원소 개수만큼 `answer` 배열 공간 확보                                                                                                                                                                                                                                                            | `id_list`의 원소 개수만큼 `answer` 배열 공간 확보                                                                             |
|   2   |                                      | `id_list`를 순환하며 `LinkedHashMap`에 신고자 정보 삽입(`stream` 적극 활용)<br/> `stream`을 통해 `report` 배열안의 원소들을 추출한다.<br/>- `filter`: 신고자의 ID로 시작하는 문자열을 추출 <br/>- `map`: `filter`를 통해 추출한 문자열들을 ' '을 기준으로 `split`한 후, 2번째 문자열 추출<br/>- `collect`: `map`을 통해 추출한 문자열들을 `Set` 객체 타입으로 변환<br/> 결과적으로 신고자의 신고 리스트들이 `LinkedHashMap`에 들어가게된다. | - `report` 배열을 `LinkedHashSet<String>` 객체로 변환하여 중복 제거<br/>- `LinkedHashMap<String, Set<String>>` 객체에 신고자의 정보를 삽입 |
|   3   |                                      |                                                                                                                                                                                                                                                                                                 | 피신고자의 이름과 신고 받은 횟수를 `reportedInfoHashMap<String, Integer>`에 저장.                                                    |

표에 동작 흐름을 비교하며 다시 살펴보니 원인을 찾아낸 것 같다.
Set 객체만에 의존하여 피신고자의 ID만을 추출하여 삽입해주면 알아서 중복해줄 거라는 것이 문제였다.

기존 코드에서 `distinct` 함수를 호출하는 코드를 추가하여 보완해보았지만 실행 시간이 초과되었다. \
`stream`안의 메소드들은 모두 반복문을 사용할 것 같기 때문에 납득이 된다. \
보완하기 전 코드도 `stream`을 통한 반복문을 남발해서 실행 시간도 비교적 높게 나왔다. 비효율적이었다.

결국 중복 제거를 제대로 처리 못한 나의 불찰이 원인이었다.

stream을 활용하며 효율적으로 데이터를 추출하는 코드를 다시 짜보았다. 
```java
    import java.util.*;
    
    class Solution_2nd_try extends Solution {
    
        public int[] solution(String[] id_list, String[] report, int k) {
    
            int[] answer = new int[id_list.length];
    
            LinkedHashMap<String, Set<String>> reporterHashMap = new LinkedHashMap<>();
            LinkedHashMap<String, Integer> reportedInfoHashMap = new LinkedHashMap<>();
    
    
            Arrays.stream(report).distinct().forEach(reportStr -> {
                String[] splitReport = reportStr.split(" ");
                reporterHashMap.putIfAbsent(splitReport[0], new HashSet<>());
                reporterHashMap.get(splitReport[0]).add(splitReport[1]);
                reportedInfoHashMap.put(splitReport[1], reportedInfoHashMap.getOrDefault(splitReport[1], 0) + 1);
            });
    
    
            reportedInfoHashMap.forEach((reportedId, count) -> {
                if (count >= k) {
                    for (int i = 0; i < id_list.length; i++) {
                        if (reporterHashMap.containsKey(id_list[i]) && reporterHashMap.get(id_list[i]).contains(reportedId))
                            ++answer[i];
                    }
                }
            });
    
    //        System.out.println("#" + this.getClass().getName());
    //        System.out.println(reportHashMap);
    //        System.out.println(reportedInfoHashMap);
    //        System.out.println(Arrays.toString(answer));
    
            return answer;
        }
    }
````
블로그를 참고하여 작성한 세번째 코드에 비해 실행 시간이 조큼 높게 나오지만 모두 통과할 수 있는 코드이다.



 


