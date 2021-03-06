// 큰 수의 법칙 

/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 나의 개선점 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 

1. 공백구분 정수 String은 nextInt()로 받기

2. 규칙있는 수열을 더할 경우,
   규칙을 알고리즘으로 나타내는 것은 시간초과일 가능성도 있음.
   "수식 표현도 고려하기"                           
ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/


          
/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 첫 구현 코드 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ 
   후기 : Greedy 알고리즘은 잘 사용했으나,
          Java가 오랜만이라 구현에서 시간이 걸렸다. (Java 학습 필요)
          초보가 생각나는대로 구구절절 구현한 코드같다. 
 ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ*/


import java.util.*;

public class Main{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    
    // 첫줄 입력받기
    String info = scan.nextLine();
    String[] NMK_str = info.split(" ");
    int[] N_M_K = new int[NMK_str.length];
    for (int i=0; i<NMK_str.length; i++){
      N_M_K[i] = Integer.parseInt(NMK_str[i]);
    }
    // 둘째줄 입력받기
    String num = scan.nextLine();
    String[] num_array_str = num.split(" ");
    Integer[] num_array = new Integer[num_array_str.length];
    for (int i=0; i<num_array_str.length; i++){
      num_array[i] = Integer.parseInt(num_array_str[i]);
    }
    // 수 배열 정렬
    Arrays.sort(num_array, Collections.reverseOrder());
    
    // Greedy에 따라 문제해결
    // Greedy Choice :
    // "제일 큰수를 최대로 더하고", 그다음 큰수를 한번 더하고의 반복
    int sum = 0;
    int upper_bound = N_M_K[2];
    for (int i=0; i<N_M_K[1]; i++){
      if(upper_bound > 0){
        sum += num_array[0];
        upper_bound -= 1;
        continue;
      }
      if (upper_bound <= 0){
        upper_bound = N_M_K[2];
        sum += num_array[1];
        continue;
      } 
    }

    System.out.println(sum);
  }
}


/* ㅡㅡㅡㅡㅡㅡㅡㅡ[ 정리된 코드 ]ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ */

import java.util.*;

public class Main {
  public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    // N, M, K 입력받기 (공백구분)
    int n = sc.nextInt();
    int m = sc.nextInt();
    int k = sc.nextInt();

    // N개의 수 입력받기 (공백구분)
    int[] arr = new int[n];
    for(int i=0; i<n; i++){
      arr[i] = sc.nextInt();
    }

    // 가장큰수, 그다음큰수만 따진다
    Arrays.sort(arr);
    int first  = arr[n-1];
    int second = arr[n-2];

    // " first 수가 더해지는 횟수 계산 "
    // 조건 : 가장 큰 수를 k번까지 연속으로 더할 수 있음
    // 즉, 총 m회 덧셈에서 cnt번 더해짐
    /* 예시 : 14회 덧셈에서 11번 더해짐
       ■ ■ ■ □ ■ ■ ■ □ ■ ■ ■ □ ■ ■ */
    int cnt = (m / (k+1)) * k;
    cnt += m % (k+1);

    // 합 결과 계산
    int sum = 0;
    sum += cnt * first;
    sum += (m - cnt) * second;

    System.out.println(sum);
  }
}



