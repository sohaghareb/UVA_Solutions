import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_1197 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		String line;
		while(!(line=bf.readLine()).equals("0 0")){
			StringTokenizer st=new StringTokenizer(line);
			int n=Integer.parseInt(st.nextToken());
			int m=Integer.parseInt(st.nextToken());
			UnionFind uf=new UnionFind(n);
			for (int i = 0; i < m; i++) {
				st=new StringTokenizer(bf.readLine());
				int k=Integer.parseInt(st.nextToken());
				if(k >0){
					int last=Integer.parseInt(st.nextToken());
					for (int j = 1; j < k; j++) {
						int y=Integer.parseInt(st.nextToken());
						uf.union(last,y );
						last=y;
					}
				}
			}
			System.out.println(uf.getSize(0)+1);
		}
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

