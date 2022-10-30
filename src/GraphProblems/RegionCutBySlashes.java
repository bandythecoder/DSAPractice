package GraphProblems;

public class RegionCutBySlashes {

    public  int[] rank;
    public int[] parent;

    public void setup(int n)
    {
        rank = new int[n];
        parent = new int[n];
        for(int i = 0; i <n ; i++)
        {
            rank[i] = 0;
            parent[i] = i;
        }
    }

    public int getParent(int x)
    {
        if(x == parent[x]) return x;
        return parent[x] = getParent(parent[x]);
    }

    public int union(int x, int y)
    {
        var x1 = getParent(x);
        var y1 = getParent(y);

        if(x1 == y1)
        {
            return 1;
        }
        if(rank[x1] > rank[y1])
        {
            parent[y1] = x1;
            rank[x1]++;
        }
        else if(rank[y1] > rank[x1])
        {
            parent[x1] = y1;
            rank[x1]++;
        }
        else
        {
            parent[y1] = x1;
            rank[x1]++;
        }
        return 0;
    }
    public int regionsBySlashes(String[] grid) {
        int n = grid.length;
        int value = (n+1)*(n+1);
        setup(value);
        int count = 1;
        int len = n+1;
        for(int i = 0; i < len; i++)
        {
            for(int j = 0; j < len ; j++)
            {
                if(i == 0 || j == 0 || i == len-1 || j == len-1)
                {
                    var cell = i * len + j;
                    if(cell!=0)
                        union(0,cell);
                }
            }

        }
        for (int i = 0; i < n; i += 1) {
            for (int j = 0; j < grid[i].length(); j += 1) {
                if (grid[i].charAt(j) == '/') {
                    int startCellNumber = i * len + (j + 1);
                    int endCellNumber = (i + 1) * len + j;
                    count += union(startCellNumber, endCellNumber);
                } else if (grid[i].charAt(j) == '\\') {
                    int startCellNumber = i * len + j;
                    int endCellNumber = (i + 1) * len + (j + 1);
                    count += union(startCellNumber, endCellNumber);
                }
            }
        }
        return count;
    }



}
