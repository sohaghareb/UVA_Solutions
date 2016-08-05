import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class UVA_13026 {//solved
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());
		for (int i = 0; i < test; i++) {
			int n=Integer.parseInt(bf.readLine());
			//StringTokenizer st=new StringTokenizer(bf.readLine());
			ArrayList<String> input=new ArrayList<String>();
			int [] min=new int [n];
			for(int i2=0;i2<n;++i2)
				input.add(bf.readLine());
			String j=bf.readLine();
			for (int j2 = 0; j2 < input.size(); j2++) {
				String tmp=input.get(j2);
				for (int k = 0; k < Math.min(j.length(), tmp.length()); k++) {
					if(tmp.charAt(k) != j.charAt(k))
						min[j2]+=1;
					
				}
				min[j2]+=Math.abs(tmp.length()-j.length());
			}
			System.out.println("Case "+(i+1)+":");
			for (int j2 = 0; j2 < min.length; j2++) {
				if(min[j2]<=1)
					System.out.println(input.get(j2));
				//System.out.println(min[j2]);
			}
		}
		
	}
	

}
