import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class UVA_10141 {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String line;
		int coun = 1;
		line = bf.readLine();
		while (!(line).equals("0 0")) {
			StringTokenizer st = new StringTokenizer(line);
			int req = Integer.parseInt(st.nextToken());
			int prop = Integer.parseInt(st.nextToken());
			for (int i = 0; i < req; i++) {
				bf.readLine();
			}
			ArrayList<nod> arr = new ArrayList<nod>();
			for (int i = 0; i < prop; i++) {
				String name = bf.readLine();
				//System.out.println(name);
				StringTokenizer stt = new StringTokenizer(bf.readLine());
				double price = Double.parseDouble(stt.nextToken());
				int rr = Integer.parseInt(stt.nextToken());
				arr.add(new nod(name,rr,price));
				for (int j = 0; j < rr; j++) {
					bf.readLine();
				}

			}
			Collections.sort(arr);

			nod x = arr.get(0);
			System.out.println("RFP #" + coun);
			System.out.println(x.name);
			line=bf.readLine();
			if(!line.equals("0 0"))
				System.out.println();
			++coun;

		}
	}

}

class nod implements Comparable<nod> {
	String name;
	int req;
	double price;

	nod(String s, int r, double p) {
		name = s;
		req = r;
		price = p;
	}

	@Override
	public int compareTo(nod o) {
		// TODO Auto-generated method stub
		if (req != o.req)
			return o.req - req;
		else {
			return (int) ((price - o.price)%((int)1e8));
		}

	}
}
