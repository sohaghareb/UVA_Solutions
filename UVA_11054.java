import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_11054 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line=bf.readLine()).equals("0")){
			int n=Integer.parseInt(line);
			long answ=0;
			StringTokenizer st=new StringTokenizer(bf.readLine());
			long result=0;
			long sum=Integer.parseInt(st.nextToken());
			for (int i = 1; i < n; i++) {
				result += (sum < 0) ? (sum * -1) : sum;
				sum+=Integer.parseInt(st.nextToken());
			}
			System.out.println(result);
			
		}
	}
}
