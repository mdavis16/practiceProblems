import java.io.*;
import java.util.StringTokenizer;


public class SoftPasswords {

    public static void main(String [] args)
    {
        SoftPasswords softPasswords = new SoftPasswords();
    }

    public SoftPasswords()
    {
        FastScanner scanner = new FastScanner(System.in);
        String oldStr = scanner.next();
        String newStr = scanner.next();

        if(!isValidPass(oldStr,newStr))
            System.out.println("No");
        else
            System.out.println("Yes");
    }

    public boolean isValidPass(String oldStr,String newStr)
    {
        if(oldStr.equals(newStr))
            return  true;


        if(newStr.length()+1 == oldStr.length()) {

            if (newStr.equals(oldStr.substring(0,oldStr.length()-1))) {
                if (oldStr.charAt(oldStr.length() - 1) >= '0' && oldStr.charAt(oldStr.length() - 1) <= '9') {
                    return true;
                }
            }

            if (newStr.equals(oldStr.substring(1,oldStr.length()))) {
                if (oldStr.charAt(0) >= '0' && oldStr.charAt(0) <= '9') {
                    return true;
                }
            }

        }

        if(revPassLetters(newStr).equals(oldStr))
            return true;

        return false;
    }

    public String revPassLetters(String s)
    {
        StringBuilder newStr = new StringBuilder(s);

        for(int i =0; i< newStr.length();i++)
        {
            if(newStr.charAt(i) >= 'a' && newStr.charAt(i) <= 'z')
            {
                newStr.setCharAt(i, Character.toUpperCase(newStr.charAt(i)));
            }
            else if (newStr.charAt(i) >= 'A' && newStr.charAt(i) <= 'Z')
            {
                newStr.setCharAt(i, Character.toLowerCase(newStr.charAt(i)));
            }
        }
        return newStr.toString();
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
