package Algoritham;

public class BackTrackingProblems
{
    public int subset_sum(int list[], int sum, int starting_index, int target_sum, int subset_count)
    {
        if( target_sum == sum )
        {
            subset_count++;
            if(starting_index < list.length)
                subset_sum(list, sum - list[starting_index-1], starting_index, target_sum, subset_count);
        }
        else
        {
            for( int i = starting_index; i < list.length; i++ )
            {
                subset_sum(list, sum + list[i], i + 1, target_sum,subset_count);
            }
        }
        return subset_count;
    }
}
