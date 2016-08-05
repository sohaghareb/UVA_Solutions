import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_12321 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line=bf.readLine()).equals("0 0")){
			StringTokenizer st=new StringTokenizer(line);
			int l=Integer.parseInt(st.nextToken());
			int g=Integer.parseInt(st.nextToken());
			ArrayList<Node> arr=new ArrayList<Node>();
			for (int i = 0; i < g; i++) {
				st=new StringTokenizer(bf.readLine());
				int x=Integer.parseInt(st.nextToken());
				int r=Integer.parseInt(st.nextToken());
				arr.add(new Node(Math.max(0, x-r), Math.min(l, x+r)));
			}
			Collections.sort(arr);
			int end=0,P2=0;int count=0;boolean flag=true;
			int i=0;
		        while (i<arr.size()) {
				int last=P2;
				while(i< arr.size() && arr.get(i).st <= end){
					P2=Math.max(P2, arr.get(i).end);
					++i;
				}
				if(last== P2){
					flag=false;break;
				}
				else{
					end=P2;
					++count;
					if(end==l)
						break;
				}
				
			}
			if(!flag || P2!= l)
				System.out.println(-1);
				
			else
				System.out.println(arr.size()-count);
			
		}
		
	}

}
class Node implements Comparable<Node>{
	int st;
	int end;
	Node(int xx,int rr){
		st=xx;
		end=rr;
	}
	@Override
	public int compareTo(Node o) {
		// TODO Auto-generated method stub
		return st-o.st;
	}
}
