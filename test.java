import java.util.ArrayList;

public class Main
{
    public static void main(String[] args)
    {
        int[] nums = {2,5,10};
        int numSize = nums.length;
        int target = 7;


        int toTarget = target;
        for (int i = 0; i < numSize; i++)
        {
            if (nums[i] >= target)
            {
                continue;
            }

            toTarget -= nums[i];
            int temp = toTarget;

            for (int j = i; j < numSize; j++)
            {
                if (j == i)
                {
                    continue;
                }

                toTarget -= nums[j];
                if (toTarget == 0)
                {
                    //return (i,j)
                }
                else
                {
                    toTarget = temp;
                }
            }
        }
    }
}
