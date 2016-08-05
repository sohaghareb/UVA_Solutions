import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class UVA_10690 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());
		for (int i = 0; i < test; i++) {
			StringTokenizer st=new StringTokenizer(bf.readLine());
			int friends=Integer.parseInt(st.nextToken());
			int friendship=Integer.parseInt(st.nextToken());
			UnionFind uf=new UnionFind(friends);
			int [] money=new int [friends];
			for (int j = 0; j < friends; j++) {
				money[j]=Integer.parseInt(bf.readLine());
			}
			for (int j = 0; j < friendship; j++) {
				st=new StringTokenizer(bf.readLine());
				uf.union(Integer.parseInt(st.nextToken()),
						Integer.parseInt(st.nextToken()));
			}
			boolean p=true;
			for (int j = 0; j < money.length; j++) {
				int m=money[j];
				if(m <0){
					for (int j2 = 0; j2 < money.length && m<0; j2++) {
						if(money[j2] >0 && uf.isSameSet(j, j2)){
							if(m*-1 <= money[j2]){//m3ah aktr mn hagty
								money[j2]+=m;
								m=0;
								break;
							}
							else{//m3ah a2l mny
								m+=money[j2];
								money[j2]=0;
							}
								
						}
					}
					if(m<0)
						p=false;
				}
			}
			if(p)
				System.out.println("POSSIBLE");
			else
				System.out.println("IMPOSSIBLE");
			
		}
	}

}
class UnionFind {
	int[] rep, rank,setSize;
	int numSets;

	public UnionFind(int N) {
		rep = new int[N];
		rank = new int[N];
		setSize=new int[N];
		numSets=N;
		for (int i = 0; i < rank.length; i++) {
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


