//김용균

import java.util.LinkedList;
import java.util.Scanner;
import java.util.Queue;


public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] targetIdx = new int[m];
        Queue<Integer> idxNum = new LinkedList<>();

        for (int i = 0; i < m; i++) {
            targetIdx[i] = sc.nextInt();
        }

        for (int i = 1; i <= n; i++) {
            idxNum.add(i);
        }

        int getIdx;
        boolean left = true;
        int cnt = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < idxNum.size(); j++) {  //타겟 숫자를 왼쪽으로 이동할 지 오른쪽으로 이동할 지 판별하기
                if(idxNum.peek() == targetIdx[i]){  //맨 앞 값을 타겟이랑 비교해서
                    getIdx = j+1;  //타겟이면 그 인덱스를 저장
                    if( getIdx <= idxNum.size()/2+1){ // 타겟 인덱스가 기준점 이하이면
                        left = true; // 왼쪽으로
                    } else {
                        left = false; // 아니면 오른쪽으로
                    }
                }
                idxNum.add(idxNum.poll()); //한 바퀴 돌려줌
            }
            if(targetIdx[i] != idxNum.peek() && left){ // 2번연산. 왼쪽으로 이동할 경우
                while(idxNum.peek() != targetIdx[i]){ // 타겟이 맨앞으로 올 때까지 dequeue해주고 그 횟수 기록
                    idxNum.poll();
                    cnt++;
                }
            } else if(targetIdx[i] != idxNum.peek() && !left){ // 3번연산오른쪽으로 이동할 경우
                int cnt1 = 0;
                while(idxNum.peek() != targetIdx[i]){ // 타겟이 맨앞에 올때까지 회전시켜주고(dequeue해주고 다시 enqueue해줌) 그 횟수 기록
                    idxNum.add(idxNum.poll());
                    cnt1++;
                }
                cnt = cnt + idxNum.size() - cnt1;
                idxNum.poll();
            } else if( targetIdx[i] == idxNum.peek()){ // 1번연산. 타겟이 이미 맨앞일 경우 바로 dequeue
                idxNum.poll();
            }
        }
        System.out.println(cnt);
    }
}
