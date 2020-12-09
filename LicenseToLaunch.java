import java.io.*;
import java.util.StringTokenizer;

public class LicenseToLaunch {

    public static void main (String [] args)
    {
        LicenseToLaunch l = new LicenseToLaunch();
    }

    public LicenseToLaunch()
    {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int [] junk = new int[n];

        int minIndex =0;
        int minVal = scanner.nextInt();

        for(int i =1; i < junk.length;i++)
        {
            junk[i] = scanner.nextInt();
            if(junk[i]<minVal)
            {
                minIndex = i;
                minVal = junk[i];
            }
        }
        System.out.println(minIndex);
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
