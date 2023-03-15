import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//      int[] arr = {4, 3, 6, 7, 8, 9, 10, 2, 1, 5}; // 예시 case1
//      int[] arr = {5, 4, 3, 2, 1}; // 예시 case2
        
        Scanner sc = new Scanner(System.in);
//        System.out.print("입력원소 갯수: ");
        int length = sc.nextInt(); // 수열 사이즈 입력
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) { // 수열의 원소 입력
//        System.out.print("원소 입력: ");
            arr[i] = sc.nextInt();
        }

        Stack<Integer>[] stack = new Stack[4]; // 4스택 생성
        for (int i = 0; i < 4; i++) {
            stack[i] = new Stack<>();
        }

        boolean yesOrNo = false; // 초기화
        for (int i = 0; i < length; i++) {
            yesOrNo = false; // 일다 매 스택에 삽입 완료 전까지 false(NO)
            for (int j = 0; j < 4; j++) {
                if (stack[j].empty()){
                    stack[j].push(arr[i]);
                    yesOrNo = true; // 빈 스택에 삽입시 YES
                    break;
                }
                else if(stack[j].peek() < arr[i]){
                    stack[j].push(arr[i]);
                    yesOrNo = true; // top값이 넣으려는 원소보다 작을 경우 삽입성공 YES
                    break;
                }
            }
        }
        if(!yesOrNo){
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }

    }
}
