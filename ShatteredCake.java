import java.io.*;
import java.util.StringTokenizer;

public class ShatteredCake {
    public static void main(String[] args) {
        ShatteredCake cake = new ShatteredCake();
    }

    public ShatteredCake()
    {
        FastScanner scan = new FastScanner(System.in);
        int width = scan.nextInt();
        int n = scan.nextInt();
        int len =0;

        for(int i=0; i < n;i++)
        {
            len += scan.nextInt() * scan.nextInt();
        }

        System.out.println(len/width);
    }

    class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        public FastScanner(Reader in) {
            br = new BufferedReader(in);
        }

        public FastScanner(InputStream in) {
            this(new InputStreamReader(in));
        }

        public String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public double nextDouble() { return Double.parseDouble(next());}
    }

}
