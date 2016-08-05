import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_624 {
	static int N,tracks,Mask;
	static ArrayList<Integer> input;
	static int best,mskbest;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=bf.readLine()) != null && !line.equals("")){
			StringTokenizer st=new StringTokenizer(line);
			N=Integer.parseInt(st.nextToken());
			tracks=Integer.parseInt(st.nextToken());
			input=new ArrayList<Integer>();
			while (st.hasMoreTokens()) {
				input.add(Integer.parseInt(st.nextToken()));
			}
			best=0;mskbest=0;
			solve(0,0,0);
			System.out.println(help(mskbest)+"sum:"+best);
				
			
		}
		}
	public static void solve(int sum, int index ,int mask){
		if(sum>best&&sum<=N)
		{
			best = sum;
			mskbest =mask;
		}
		if(index == tracks)
			return ;
		if(sum > N)
			return ;
		solve(sum+input.get(index) , index+1, mask | (1<<index));//taken
	    solve(sum , index+1,mask);//not taken
	    
	}
	
	public static String help(int mask){
		String k=Integer.toBinaryString(mask);
		//System.out.println(k);
		String r="";int l=k.length()-1;
		for (int i =l; i >=0; i--) {
			if(k.charAt(i) == '1')
				r+=input.get(l-i)+" ";
			}
		return r;
	}
	

}
