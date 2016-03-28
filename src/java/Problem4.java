import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by chanming on 16/3/28.
 */

public class Problem4 {

    /**
     * result[0] how many number less or equal p, result[1] the most number less or equal o
     * @param nums
     * @param p
     * @return
     */
    private int[] findEL(int[] nums, int p){
        int result[] = new int[2];

        int l = -1;
        int r = nums.length - 1;
        while (l < r){
            int mid = (l + r) / 2 + 1;
            if (nums[mid] <= p){
                l = mid;
            }else{
                r = mid - 1;
            }
        }
        if (l == -1){
            //deal with empty array
            //deal with not one less than p
            result[0] = 0;
            return result;
        }
        result[0] = l + 1;
        result[1] = nums[l];
        return result;
    }

    private Integer interFind(int[] nums1, int[] nums2){
        int l = -1;
        int r = nums1.length - 1;
        while (l < r){
            int mid = (l + r) / 2 + 1;
            int tmpresult[] = findEL(nums2, nums1[mid]);
            int lETotal = mid + 1 + tmpresult[0];
            int mTotal = (nums1.length + nums2.length) - lETotal - 1;
            if (lETotal - mTotal > 1){
                r = mid - 1;
            }else{
                l = mid;
            }
        }
        if (l == -1){
            return null;
        }
        int tmpresult[] = findEL(nums2, nums1[l]);
        int lETotal = l + 1 + tmpresult[0];
        int mTotal = (nums1.length + nums2.length) - lETotal - 1;
        if (lETotal - mTotal >= 0){
            return nums1[l];
        }
        return null;
    }

    private double findMedianSortedArraysOdd(int[] nums1, int[] nums2){
        Integer tmp = interFind(nums1, nums2);
        if (tmp != null){
            return tmp;
        }else{
            return interFind(nums2, nums1);
        }
    }

    private double findMedianSortedArraysEven(int[] nums1, int[] nums2){
        Integer tmp = interFind(nums1, nums2);
        if (tmp != null){
            int[] tmpResult1 = findEL(nums1, tmp);
            int[] tmpResult2 = findEL(nums2, tmp);
            if (tmpResult1[0] > 1){
                if (tmpResult2[0] > 1){
                    int answer = Math.max(nums1[tmpResult1[0] - 1], nums2[tmpResult2[0] - 1]);
                    return (tmp + answer)/ 2.0;
                }else{
                    int answer = nums1[tmpResult1[0] - 1];
                    return (tmp + answer) / 2.0;
                }
            }else{
                if (tmpResult2[0] > 1){
                    int answer = nums2[tmpResult2[0] - 1];
                    return (tmp + answer) / 2.0;
                }
                return tmp;
            }
        }else{
            tmp = interFind(nums2, nums1);
        }
        return 0;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if ((nums1.length + nums2.length) % 2 == 1){
            return findMedianSortedArraysOdd(nums1, nums2);
        }else{
            return findMedianSortedArraysEven(nums1, nums2);
        }
    }
}
