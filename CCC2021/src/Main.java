import java.util.*;
import java.io.*;
public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static boolean[] visited;
	
	public static boolean bfs(int p, int q, ArrayList<Integer>[] list) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(q);
		visited[q] = true;
		while (!queue.isEmpty()) {
			int temp = queue.poll();
			if (temp==p) {
				return true;
			}
			for (int i: list[temp]) {
				if (!visited[i] || i==p) {
					queue.add(i);
					visited[i] = true;
				}
			}
		}
		return false;
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		int N = readInt(), M = readInt();
		ArrayList<Integer>[] list = new ArrayList[N+1];
		visited = new boolean[N+1];
		for (int i=0; i<list.length; i++) {
			list[i] = new ArrayList<Integer>();
		}
		for (int i=0; i<M; i++) {
			int a = readInt(), b = readInt();
			list[b].add(a);
		}
		int p = readInt(), q = readInt();
		
		if (bfs(p, q, list)) {
			System.out.println("yes");
		} else if (bfs(q, p, list)) {
			System.out.println("no");
		} else {
			System.out.println("unknown");
		}
	}

	static String next() throws IOException {
		while (st == null || !st.hasMoreTokens())
			st = new StringTokenizer(br.readLine().trim());
		return st.nextToken();
	}

	static long readLong() throws IOException {
		return Long.parseLong(next());
	}

	static int readInt() throws IOException {
		return Integer.parseInt(next());
	}

	static double readDouble() throws IOException {
		return Double.parseDouble(next());
	}

	static char readCharacter() throws IOException {
		return next().charAt(0);
	}

	static String readLine() throws IOException {
		return br.readLine().trim();
	}
}
