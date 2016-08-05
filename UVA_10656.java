import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_10656 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line=bf.readLine()).equals("0")){
			int n=Integer.parseInt(line);
			int [] arr=new int[n];
			for (int i = 0; i < n; i++) {
				arr[i]=Integer.parseInt( bf.readLine());
			}
			int p1=-1,p2=-1;
			for (int i = 0; i < arr.length; i++) {
				if(arr[i] > 0){
					if(p1 == -1){
						p1=i;p2=i;
					}
					else{
						p2=i;
					}
				}
			}
			if(p1 != -1 && p2!=-1){
				String s="";
				for (int i = p1; i <= p2; i++) {
					if(arr[i] > 0){
					s+=arr[i];
					if(i < p2)
						s+=" ";
					}
				}
				System.out.println(s);
			}
			else{
				System.out.println(0);
			}
		}
	}

}
