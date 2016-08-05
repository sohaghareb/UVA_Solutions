import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_729 {
	static int N,H;
	static ArrayList<String> ans;

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());
		//bf.readLine();
		for (int i = 0; i < test; i++) {
			bf.readLine();
			StringTokenizer st=new StringTokenizer(bf.readLine());
			N=Integer.parseInt(st.nextToken());
			H=Integer.parseInt(st.nextToken());
			ans= new ArrayList<String>();
			solve("",0);
			for (int j = 0; j < ans.size(); j++) {
				//String tmp=ans.get(j);
				System.out.println(complete(ans.get(j)));
			}
			if(i < test-1)
				System.out.println();
		}
		
	}
	public static void solve(String s,int ones){
		if(ones==H)
			ans.add(s);
		else if(s.length() == N)
			return;
		else{
			solve(s+"0",ones);
			solve(s+"1",ones+1);
		}
		
	}
	public static void solve_2(int s,int ones,int index)
	{
		if(H == ones || index == N){
			ans.add(s+"");
		}
		else {
			solve_2(s | 1<<index, ones+1,index+1);
			solve_2(s, ones,index+1);
		}
		
	}
	public static String complete(String s){
		int limit=(N-s.length());
		for (int i = 0; i <limit ; i++) {
			s+="0";
		}
		return s;
		
	}

}
