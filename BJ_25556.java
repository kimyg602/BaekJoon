import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
//      int[] arr = {4, 3, 6, 7, 8, 9, 10, 2, 1, 5};
//      int[] arr = {5, 4, 3, 2, 1};
        Scanner sc = new Scanner(System.in);
//        System.out.print("입력원소 갯수: ");
        int length = sc.nextInt();
        int[] arr = new int[length];
        for (int i = 0; i < length; i++) {
//        System.out.print("원소 입력: ");
            arr[i] = sc.nextInt();
        }

        Stack<Integer>[] stack = new Stack[4];
        for (int i = 0; i < 4; i++) {
            stack[i] = new Stack<>();
        }

        boolean yesOrNo = false;
        for (int i = 0; i < length; i++) {
            yesOrNo = false;
            for (int j = 0; j < 4; j++) {
                if (stack[j].empty()){
                    stack[j].push(arr[i]);
                    yesOrNo = true;
                    break;
                }
                else if(stack[j].peek() < arr[i]){
                    stack[j].push(arr[i]);
                    yesOrNo = true;
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
