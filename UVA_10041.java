import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10041 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());
		for (int i = 0; i < test; i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			ArrayList<Integer> arr=new ArrayList<Integer>();
			st.nextToken();
			while(st.hasMoreTokens())
				arr.add(Integer.parseInt(st.nextToken()));
			Collections.shuffle(arr);
			Collections.sort(arr);
			int index=arr.size()/2;
			int num=arr.get(index);int dist=0;
			for (int j = 0; j < arr.size(); j++) {
				dist+=Math.abs(arr.get(j)-num);
			}
			System.out.println(dist);
		}
	}
}
