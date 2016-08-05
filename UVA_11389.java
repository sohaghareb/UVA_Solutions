import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_11389 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		while ((line = bf.readLine()) != null && !line.equals("0 0 0")) {
			StringTokenizer st = new StringTokenizer(line);
			int n = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int r = Integer.parseInt(st.nextToken());
			ArrayList<Integer> morning = new ArrayList<Integer>();
			ArrayList<Integer> evening = new ArrayList<Integer>();
			st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens())
				morning.add(Integer.parseInt(st.nextToken()));
			st = new StringTokenizer(bf.readLine());
			while (st.hasMoreTokens())
				evening.add(Integer.parseInt(st.nextToken()));
			int penalty = 0;
			Collections.sort(morning);
			Collections.sort(evening);
			int st2 = 0;
			int end = n - 1;
			for (int i = 0; i < n; i++) {
				int bus = morning.get(st2++) + evening.get(end--);
				if (bus > d)
					penalty += (bus - d) * r;

			}
			System.out.println(penalty);

		}
	}

}
