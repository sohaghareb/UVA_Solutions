import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class UVA_793 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		int test=Integer.parseInt(bf.readLine());int count=0;
		String line;bf.readLine();
		PrintWriter pw=new PrintWriter(System.out);
		while(count < test){
			line=bf.readLine();
			int n=Integer.parseInt(line);
			UnionFind uf= new UnionFind(n);
			int suc=0,fail=0;
			while (((line=bf.readLine()) != null && !line.equals(""))) {
				StringTokenizer st=new StringTokenizer(line);
				if(st.nextToken().equals("c")){
					uf.union(Integer.parseInt(st.nextToken()),
							Integer.parseInt(st.nextToken()));
				}
				else{
					if(uf.isSameSet(Integer.parseInt(st.nextToken()), 
							Integer.parseInt(st.nextToken())))
						++suc;
					else
						++fail;
				}
			}
			pw.append(suc+","+fail);
			if(count < test-1)
				pw.append("\n"+"\n");
			++count;
		}
		pw.append("\n");
		pw.flush();pw.close();
	}
}
