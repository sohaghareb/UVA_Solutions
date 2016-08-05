import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UVA_674 {
	static int max;
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int []arr= {50,25,10,5,1};
		while ((line = bf.readLine()) != null) {
			max=(int)1e8;
			int money=Integer.parseInt(line);
			int c=0;
			System.out.println(calc2(money,arr));	
		}
	}
	public static int calc2(int N,int [] arr){
		if(N==0)
			return 1;
		else{
			int ans=0;
			for (int i = 0; i < arr.length; i++) {
				if(N >= arr[i] && arr[i] < max){
					max=arr[i];
					ans+=calc2(N-arr[i],arr);
				}
				
			}
			return ans;
		}
	}
	public static int calc(int money,int index, int currency,int [] arr){
		if( money==0)
			return currency;
		if(index > 4 )
			return (int)1e8;	
		else if(money >= arr[index]){
			int take=calc(money%arr[index],index+1,currency+money/arr[index],arr);
			int notTake=calc(money,index+1,currency,arr);
			return Math.min(take, notTake);
		}
		else{
			return calc(money,index+1,currency,arr);
		}
	}

}
