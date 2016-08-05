import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class UVA_10152 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(bf.readLine());
		for (int i = 0; i < test; i++) {
			int n = Integer.parseInt(bf.readLine());
			ArrayList<String> original = new ArrayList<String>();
			ArrayList<String> sorted = new ArrayList<String>();
			for (int j = 0; j < n; j++) {
				original.add(bf.readLine());
			}
			for (int j = 0; j < n; j++) {
				sorted.add(bf.readLine());
			}
			int pO=n-1,pS=n-1;
			while(pO >=0){
				if(original.get(pO).equals(sorted.get(pS))){
					--pO;--pS;
				}
				else{
					--pO;
				}
			}
			while(pS >=0){
				System.out.println(sorted.get(pS));
				--pS;
			}
//			if(i <test-1)
				System.out.println();
		}
	}
}
