import java.io.*;
import java.util.StringTokenizer;

public class GrandpaCheckerboard {

    public static void main (String [] args)
    {
        GrandpaCheckerboard g = new GrandpaCheckerboard();
    }

    public GrandpaCheckerboard()
    {
        FastScanner scanner = new FastScanner(System.in);
        int size = scanner.nextInt();
        char [][]  board = new char[size][size];
        int r =0;
        int c =0;

        for(int i = 0; i < size;i++)
        {
            String s = scanner.next();
            for(int x =0; x < s.length();x++)
            {
                board[i][x] = s.charAt(x);
            }
        }

        if(validateBoard(board,size))
            System.out.println(1);
        else
            System.out.println(0);

    }

    public boolean validateBoard(char [][] board,int size)
    {

        for(int i =0; i <size;i++)
        {
            String row = getRow(board,i);
            String col = getCol(board,i);

            int [] rowColorCounts = getColorCounts(row);
            int [] colColorCounts = getColorCounts(col);

            if(rowColorCounts[0] != rowColorCounts[1] || colColorCounts[0] != colColorCounts[1])
                return false;

            if(checkConsecutive(row) || checkConsecutive(col))
                return false;
        }


        return true;
    }

    public boolean checkConsecutive(String s)
    {
        int prev  = '!';
        int count =1;

        for(int i =0; i < s.length();i++)
        {
            if(prev != '!')
            {
                if(s.charAt(i) == prev)
                {
                    count++;
                }
                else {
                    count =1;
                }
            }

            prev = s.charAt(i);

            if(count >= 3)
                return  true;
        }


        return false;
    }

    public int [] getColorCounts(String s)
    {
        int[] colors = new int[2];
        for(int i =0; i < s.length();i++)
        {
            if(s.charAt(i)== 'W')
                colors[0]++;
            else
                colors[1]++;
        }
        return colors;
    }

    public String getRow(char [][] board,int row)
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < board.length;i++)
        {
            s.append(board[row][i]);
        }
        return s.toString();
    }

    public String getCol(char [][] board,int col)
    {
        StringBuilder s = new StringBuilder();
        for(int i = 0; i < board.length;i++)
        {
            s.append(board[i][col]);
        }
        return s.toString();
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
