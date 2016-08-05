import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11292 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while (!(line = bf.readLine()).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());// dragons dia,eter
			int m = Integer.parseInt(st.nextToken());// knights
			ArrayList<Integer> heads = new ArrayList<Integer>();
			ArrayList<Integer> knight = new ArrayList<Integer>();
			for (int i = 0; i < n; i++) {
				heads.add(Integer.parseInt(bf.readLine()));
			}
			for (int i = 0; i < m; i++) {
				knight.add(Integer.parseInt(bf.readLine()));
			}
			Collections.sort(heads);
			Collections.sort(knight);
			int last = 0;
			int ans = 0;int h=0;
			for (int i = 0; i < n; i++) {
				int j;
				for (j = last; j < knight.size(); j++) {
					if (heads.get(i) <= knight.get(j)) {
						ans += knight.get(j);
						++h;
						break;
					}
				}
				last = j + 1;
			}
			if(h==n)
				System.out.println(ans);
			else
				System.out.println("Loowater is doomed!");

		}
	}

}
