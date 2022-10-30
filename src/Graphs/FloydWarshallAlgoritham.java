package Graphs;

public class FloydWarshallAlgoritham {

    public int[][] shortestPath(int[][] matrix)
    {
        int n = matrix.length;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < n; j++)
            {
                if(i==j) matrix[i][j] = 0;
                if(matrix[i][j] == -1) matrix[i][j] = 10000;
            }
        }

        for(int k = 0; k < n; k++)
        {
            for(int i = 0; i < n; i++)
            {
                for(int j = 0; j < n;  j++)
                {

                    if(matrix[i][k] + matrix[k][j] < matrix[i][j])
                    {
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                    }

                    if(matrix[i][j] < 0)
                    {
                        // negative
                    }
                }
            }
        }
        return matrix;
    }
}
