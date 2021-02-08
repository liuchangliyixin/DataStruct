package sort;

/**
 * @author yixiu
 * @title: QucikShort
 * @projectName DataStruct
 * @description: 快速排序
 * @date 2020/12/1219:07
 */
public class QuickShort {

    public static void recQuickShort(int[] nums){
        int length = nums.length;
        //quickSort(0,length-1,nums);
        quickSort2(0,length-1,nums);
    }

    //-------------------- 枢纽：最右边数据项------------------
    private static void quickSort(int left, int right, int[] nums) {
        if(right - left <= 0) //只有一个数据，有序，直接返回
            return;

        int pivot = nums[right];//选择最右端数据作为枢纽
        int partition = partition(left,right,pivot,nums);//划分数据，设置枢纽位置

        quickSort(left,partition-1,nums);//调用自身为枢纽左半部分排序
        quickSort(partition+1,right,nums);//调用自身为枢纽右半部分排序
    }

    //划分数据
    private static int partition(int left, int right, int pivot,int[] nums) {
        int leftPtr = left-1;
        int rightPtr = right;//最右边的数据作为枢纽不参与循环

        while(true){
            //不用担心左指针越界，因为枢纽是最右端数据
            while (nums[++leftPtr] < pivot)
                ;

            while (rightPtr > 0 && nums[--rightPtr] > pivot)
                ;

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr,rightPtr,nums);
        }
        swap(leftPtr,right,nums);
        return leftPtr;
    }
    //-------------------- 枢纽：最右边数据项------------------

    //-------------------- 枢纽：3数据项取中------------------

    private static void quickSort2(int left, int right, int[] nums) {
        int currentLength = right - left + 1;//当前参与排序的数据项数
        if(currentLength <= 3)//小于等于3个，直接比较排序
            manualSort(left,right,nums);
        else{//大于3个采用3数据项取中
            int pivot = medianOf3(left,right,nums);
            int partition = partition2(left,right,pivot,nums);
            quickSort2(left,partition-1,nums);
            quickSort2(partition+1,right,nums);
        }
    }

    private static void manualSort(int left, int right, int[] nums) {
        int currentLength = right - left + 1;
        if(currentLength <= 1)
            return;
        if(currentLength == 2){
            if(nums[left] > nums[right])
                swap(left,right,nums);
        }
        if(currentLength == 3){
            if(nums[left] > nums[right-1]){
                swap(left,right-1,nums);
            }
            if(nums[left] > nums[right]){
                swap(left,right,nums);
            }
            if(nums[right-1] > nums[right]){
                swap(right-1,right,nums);
            }
        }
    }

    private static int medianOf3(int left, int right, int[] nums) {
        int center = (left+right)/2;

        if(nums[left] > nums[center])
            swap(left,center,nums);
        if(nums[left] > nums[right])
            swap(left,right,nums);
        if(nums[center] > nums[right])
            swap(center,right,nums);

        swap(center,right-1,nums);
        return nums[right-1];
    }

    private static int partition2(int left, int right, int pivot, int[] nums) {
        int leftPtr = left;
        int rightPtr = right-1;

        while(true){
            //不用担心左指针越界，因为数组最右端数据已经大于枢纽
            while(nums[++leftPtr] < pivot)
                ;
            //不用担心右指针越界，因为数组最左端数据已经小于枢纽
            while(nums[--rightPtr] > pivot)
                ;

            if(leftPtr >= rightPtr)
                break;
            else
                swap(leftPtr,rightPtr,nums);
        }
        swap(leftPtr,right-1,nums);
        return leftPtr;
    }

    //-------------------- 枢纽：3数据项取中------------------

    //交换数据
    private static void swap(int leftPtr, int rightPtr,int[] nums) {
        int temp = nums[leftPtr];
        nums[leftPtr] = nums[rightPtr];
        nums[rightPtr] = temp;
    }

    public static void show(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] nums = {2,6,34,23,45,1,2,4,5,78,9};
        show(nums);
        recQuickShort(nums);
        show(nums);
    }
}
