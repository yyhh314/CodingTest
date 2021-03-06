// 숫자 카드 게임 

/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 나의 개선점 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
1. 문제가 요구하는 것을 직빵으로 해결하는 법을 먼저 생각하자.
   굳이 구체적으로 구현하려 하지 말자는 것이다. 낭비다!
   
2. Math.min(A, B); 
   Math.max(A, B);
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */




/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 첫 구현 코드 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
후기 : 쓸데없는 과정이 좀 들어가 있다.
       그냥 row line이 들어올 때 minimum을 바로 파악해도 됐었는데,
       나는 굳이 card 2차원배열을 만들었다는게 혼나야할 부분
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */
import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    // 행, 열 입력
    int N = sc.nextInt();
    int M = sc.nextInt();

    // 숫자 카드 2차원배열
    int[][] card = new int[N][M];
    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        int n_ = sc.nextInt();
        card[i][j] = n_;
      }
    }

    // Greedy
    // 각 행의 min이 가장 큰 행을 고르기
    int[] row_min = new int[N];
    for (int i = 0; i < N; i++) {
      int min_ = card[i][0];
      for (int j = 1; j < M; j++) {
        if (card[i][j] < min_) {
          min_ = card[i][j];
        }
      }
      row_min[i] = min_;
    }
    Arrays.sort(row_min);
    int result = row_min[N-1];

    System.out.println(result);
  }
}




/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 정리된 코드 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
- 카드의 수는 10000이 최대이므로 min_value = 10001로 초기화
- 그리고 각 row에 있는 수를 즉시 min_value와 비교, 갱신
- row를 바꿀 때마다 result(최대값) 갱신
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/

int result = 0;
for (int i=0; i<N; i++){
  // 현재 line에서 min값 찾기
  int min_value = 10001;
  for (int j=0; j<M; j++) {
    int x = sc.nextInt();
    min_value = Math.min(min_value, x);
  }
  // 각 행의 min값의 max를 갱신
  result = Math.max(result, min_value);
}
// 결과 출력
System.out.println(result);


