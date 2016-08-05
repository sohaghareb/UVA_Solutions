import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_12854 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while((line=bf.readLine())!= null){
			StringTokenizer st=new StringTokenizer(line);
			StringTokenizer st2=new StringTokenizer(bf.readLine());
			boolean f=true;
			while(st.hasMoreTokens()){
				int x=Integer.parseInt(st.nextToken());
				int y=Integer.parseInt(st2.nextToken());
				if(x==y){
					System.out.println("N");
					f=false;
					break;
				}
					
			}
			if(f)
				System.out.println("Y");
				
		}
		}

}
