import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_100 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=bf.readLine()) != null){
			StringTokenizer st=new StringTokenizer(line);
			int i=Integer.parseInt(st.nextToken());
			int j=Integer.parseInt(st.nextToken());
			int count=0;int tmp=i;
			int max,min;
			if(i > j){
				max=i;
				min=j;
			}
			else{
				max=j;
				min=i;
			}
			for (int k = min; k <= max; k++) {
				int t=calc(k);
				if(count < t){
					count= t;
				}
			}
			System.out.println(i+" "+j+" "+count);	
		}
	}
	public static int calc(int n) {
        int bb = 1;
        while (n != 1) {
            if (n % 2 == 1)
                n = 3 * n + 1;
            else
                n /=2;
            bb++;
        }
        return bb;
    }

}
