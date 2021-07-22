package strategies.chap24;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;
import strategies.chap21.Node;

public class MeasureTime {

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    int C = Integer.parseInt(br.readLine());
    while(C-- > 0){
      int N = Integer.parseInt(br.readLine());
      ArrayList<Integer> arrayList = new ArrayList<>();
      StringTokenizer st = new StringTokenizer(br.readLine());
      for(int i = 0; i < N; i++){
        arrayList.add(Integer.parseInt(st.nextToken()));
      }
      bw.write(solve(arrayList) + "\n");
      bw.flush();
    }
  }

  private static long solve(ArrayList<Integer> arrayList) {
    FenwickTree fenwickTree = new FenwickTree(1000000);
    long ret = 0;
    for (Integer integer : arrayList) {
      ret += fenwickTree.sum(999999) - fenwickTree.sum(integer);
      fenwickTree.add(integer, 1);
    }
    return ret;
  }

}