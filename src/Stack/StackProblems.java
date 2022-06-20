package Stack;

import java.util.*;

public class StackProblems
{
    public static class Pair
    {
        public Pair(int key, int value) {
            this.key = key;
            this.value = value;
        }

        int key;

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        int value;

    }
   public List<Integer> findLargestOnRight(int[] nums)
   {
       int n = nums.length;
       Stack<Integer> s = new Stack<>();
       List<Integer> liValues = new ArrayList<>();

       liValues.add(-1);
       s.push(nums[n-1]);
       for(int i = n-2; i >= 0; i--)
       {
           while(!s.isEmpty() && s.peek() <= nums[i])
           {
               s.pop();
           }
           if(s.peek() > nums[i])
           {
               liValues.add(s.peek());
               s.push(nums[i]);
           }
           else if(s.isEmpty())
           {
               liValues.add(s.peek());
               s.push(nums[i]);
           }

       }
       Collections.reverse(liValues);
       return liValues;
   }

   public List<Integer> findLargestToLeft(int[] nums)
   {
       int n = nums.length;
       Stack<Integer> s = new Stack<Integer>();
       List<Integer> liValues = new ArrayList<Integer>();
       for(int  i = 0; i < n ; i++)
       {
           if(s.size() == 0)
           {
               liValues.add(-1);
               s.push(nums[i]);

           }
           else if(s.size() > 0 && s.peek() > nums[i])
           {
               liValues.add(s.peek());
               s.push(nums[i]);
           }
           else if(s.size() > 0 && s.peek() <= nums[i])
           {
               while(!s.isEmpty() && s.peek() <= nums[i])
               {
                   s.pop();
               }
               if(!s.isEmpty())
               {
                   liValues.add(s.peek());
                   s.push(nums[i]);
               }
               else
               {
                   liValues.add(-1);
                   s.push(nums[i]);
               }
           }
       }
       return liValues;
   }

   public List<Integer> findSmallestOnRight(int[] nums)
   {
       int n = nums.length;
       List<Integer> li = new ArrayList<>();
       Stack<Integer> s = new Stack<>();
       for(int i = n-1;  i >= 0 ; i--)
       {
           if(s.size() == 0)
           {
               li.add(-1);
               s.push(nums[i]);
           }
           else if(s.size() > 0 && s.peek() < nums[i])
           {
               li.add(s.peek());
               s.push(nums[i]);
           }
           else if(s.size() > 0 && s.peek() >= nums[i])
           {
               while(!s.empty() && s.peek() >= nums[i])
               {
                   s.pop();
               }
               if(!s.isEmpty())
               {
                   li.add(s.peek());
                   s.push(nums[i]);
               }
               else
               {
                   li.add(-1);
                   s.push(nums[i]);
               }
           }
       }
        Collections.reverse(li);
       return li;
   }

    public List<Integer> findSmallestOnLeft(int[] nums)
    {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        for(int i = 0;  i < n; i++)
        {
            if(s.size() == 0)
            {
                li.add(-1);
                s.push(nums[i]);
            }
            else if(s.size() > 0 && s.peek() < nums[i])
            {
                li.add(s.peek());
                s.push(nums[i]);
            }
            else if(s.size() > 0 && s.peek() >= nums[i])
            {
                while(!s.empty() && s.peek() >= nums[i])
                {
                    s.pop();
                }
                if(!s.isEmpty())
                {
                    li.add(s.peek());
                    s.push(nums[i]);
                }
                else
                {
                    li.add(-1);
                    s.push(nums[i]);
                }
            }
        }

        return li;
    }

    public List<Integer> stockSpan(int[] nums)
    {
        int n = nums.length;
        List<Integer> li = new ArrayList<>();
        Stack<Pair> stack = new Stack();
        for(int i = 0; i < n ; i++)
        {
            if(stack.size() == 0)
            {
                li.add(1);
                stack.push(new Pair(i,nums[i]));
            }
            else if(stack.size() > 0 && stack.peek().value > nums[i])
            {
                li.add(i - stack.peek().key);
                stack.push(new Pair(i,nums[i]));
            }
            else if(stack.size() > 0 && stack.peek().value < nums[i])
            {
                while(!stack.isEmpty() && stack.peek().value < nums[i])
                {
                    stack.pop();
                }
                if(stack.isEmpty())
                {
                    li.add(1);
                    stack.push(new Pair(i,nums[i]));
                }
                else
                {
                    li.add(i - stack.peek().key);
                    stack.push(new Pair(i,nums[i]));
                }
            }
        }
        return li;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        List<Integer> liLeft = NSL(heights,n);
        List<Integer> liRight = NSR(heights,n);
        int maxArea = Integer.MIN_VALUE;
        for(int i = 0; i < n ; i++)
        {
            maxArea = Math.max(maxArea, (liRight.get(i) - liLeft.get(i) -1) * heights[i]);
        }
        return maxArea;
    }

    private List<Integer> NSL(int[] nums, int n)
    {
        List<Integer> li = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        for(int i = 0; i < n; i++)
        {
            if(s.size() == 0)
            {
                li.add(-1);
                s.push(new Pair(i,nums[i]));
            }
            else if(s.size() > 0 && s.peek().getValue() < nums[i])
            {
                li.add(s.peek().getValue());
                s.push(new Pair(i, nums[i]));
            }
            else if(s.size() > 0 && s.peek().getValue() >= nums[i])
            {
                while(!s.isEmpty() && s.peek().getValue() >= nums[i])
                {
                    s.pop();
                }
                if(s.size() == 0)
                {
                    li.add(-1);
                    s.push(new Pair(i,nums[i]));
                }
                else
                {
                    li.add(s.peek().getValue());
                    s.push(new Pair(i, nums[i]));
                }
            }

        }
        return li;
    }

    private List<Integer> NSR(int[] nums, int n)
    {
        List<Integer> li = new ArrayList<>();
        Stack<Pair> s = new Stack<>();
        for(int i = n-1; i >= 0; i--)
        {
            if(s.size() == 0)
            {
                li.add(n);
                s.push(new Pair(i,nums[i]));
            }
            else if(s.size() > 0 && s.peek().getValue() < nums[i])
            {
                li.add(s.peek().getValue());
                s.push(new Pair(i, nums[i]));
            }
            else if(s.size() > 0 && s.peek().getValue() >= nums[i])
            {
                while(!s.isEmpty() && s.peek().getValue() >= nums[i])
                {
                    s.pop();
                }
                if(s.size() == 0)
                {
                    li.add(n);
                    s.push(new Pair(i,nums[i]));
                }
                else
                {
                    li.add(s.peek().getValue());
                    s.push(new Pair(i, nums[i]));
                }
            }

        }
        Collections.reverse(li);
        return li;
    }

    private int[] reverse(int[] arr)
    {
        int n = arr.length;
        int  i = 0;
        int j = n-1;

        while(i < j)
        {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
        return arr;
    }

    public  int carFleet(int target, int[] position, int[] speed) {
        int n = position.length;
        int[][] cars = new int[n][2];
        Stack<Double> stack = new Stack<>();

        for(int i = 0; i < n ; i++)
        {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(b[0],a[0]));

        for(int i = 0; i < n ;i++)
        {
            if(stack.size() == 0)
            {
                double value  = (target - cars[i][0])/cars[i][1];
                stack.push(value);
            }
            else
            {
                double prev =  stack.peek();
                double curr = (target - cars[i][0])/(double)cars[i][1];
                if(curr > prev)

                    stack.push(curr);
            }

        }
        return stack.size();

    }
}
