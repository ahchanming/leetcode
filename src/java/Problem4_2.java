/**
 * Created by chanming on 16/3/28.
 */

public class Problem4_2 {

    private double innerFind(int[] nums1, int[] nums2){
        int minn = Math.min(nums1[0], nums2[0]);
        int maxx = Math.max(nums1[nums1.length - 1], nums2[nums2.length - 1]);

    }
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return innerFind(nums1, nums2);
    }
}
