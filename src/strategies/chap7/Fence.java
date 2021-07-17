package strategies.chap7;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Fence {

  public static void main(String[] args) throws Exception{
    File file = new File("./src/goo/chap7/input/fence.txt");
    Scanner sc = new Scanner(file);

    int C = sc.nextInt();
    while (C-- > 0) {
      int N = sc.nextInt();
      ArrayList<Integer> board = new ArrayList<>();
      for(int i = 0; i < N; i++){
        board.add(sc.nextInt());
      }
      System.out.println(fence(board));
    }
  }

  private static int fence(List<Integer> board) {
    if(board.size() == 1) return board.get(0);

    int lo = 0;
    int hi = board.size();

    int mid = (lo + hi) / 2;

    int leftMax = fence(board.subList(lo, mid));
    int rightMax = fence(board.subList(mid, hi));

    int answer = Math.max(leftMax, rightMax);

    int left = mid - 1;
    int right = mid;

    int height = Math.min(board.get(left), board.get(right));

    while(left > lo && right < hi){
      if(right < hi - 1 && (lo == left - 1 || board.get(left - 1) < board.get(right + 1))){
        ++right;
        height = Math.min(height, board.get(right));
      } else{
        --left;
        height = Math.min(height, board.get(left));
      }
      answer = Math.max(answer, height * (right - left + 1));
    }
    return answer;
  }

}
