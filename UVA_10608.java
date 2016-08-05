import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA_10608 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());
		for (int i = 0; i < test; i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int N=Integer.parseInt(st.nextToken());
			int M=Integer.parseInt(st.nextToken());
			UnionFind uf=new UnionFind(N);
			for (int j = 0; j < M; j++) {
				st=new StringTokenizer(bf.readLine());
				uf.union(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
			}
			System.out.println(max(uf.setSize));
			
			
		}
		
	}
	public static int max(int [] arr){
		int max=arr[0];
		for (int i = 1; i < arr.length; i++) {
			if(arr[i] > max)
				max=arr[i];
		}
		return max;
	}

}
 class UnionFind {
	int[] rep, rank,setSize;
	int numSets;

	public UnionFind(int N) {
		rep = new int[N+1];
		rank = new int[N+1];
		setSize=new int[N+1];
		numSets=N;
		for (int i = 1; i < rank.length; i++) {
			rep[i] = i;
			rank[i]=1;
			setSize[i]=1;
		}
		
	}

	public int findSet(int x) {
		if (x == rep[x])
			return x;
		else
			return rep[x] = findSet(rep[x]);
	}

	public boolean isSameSet(int x, int y) {
		return findSet(x) == findSet(y);
	}
	public int getSize(int x){
		return setSize[findSet(x)];
	}

	public void union(int x, int y) {
		int xParent=findSet(x);
		int yParent=findSet(y);
		if(xParent==yParent)
			return;
		int rankX=rank[xParent];
		int rankY=rank[yParent];
		if(rankX == rankY){//kda el x pointing to y then rank y wll increase 
			rep[xParent]=yParent;// it is better if they are equal to compare with size
			rank[yParent]++;
			setSize[yParent]+=setSize[xParent];
		}
		else if(rankX > rankY){
			rep[yParent]=xParent;
			setSize[xParent]+=setSize[yParent];
		}
		else{
			rep[xParent]=yParent;
			setSize[yParent]+=setSize[xParent];
		}
		--numSets;
	}

}
