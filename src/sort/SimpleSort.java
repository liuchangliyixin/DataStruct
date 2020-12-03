package sort;

/**
 * @author yixiu
 * @title: SimpleSort
 * @projectName DataStruct
 * @description: 基本排序算法
 * @date 2020/12/3 13:40
 */
public class SimpleSort {

    /**
      * @Author yixiu
      * @Description 冒泡排序
      * @Date 14:28 2020/12/3
      * @Param
      * @return
      **/
    public static void bubbleSort(int[] nums){
        int size = nums.length;
        int out,in;
        //外层循环从最后一个元素开始
        for(out = size-1; out > 1; out--){
            //内层循环从第一个数开始，到外层循环停止，
            for(in = 0;in < out-1; in++){
                int left = nums[in];
                int right = nums[in+1];
                //左边的数 大于 右边的数，交换数据
                if(left > right){
                    nums[in+1] = left;
                    nums[in] = right;
                }
            }
        }
    }

    /**
      * @Author yixiu
      * @Description 选择排序
      * @Date 17:38 2020/12/3
      * @Param
      * @return
      **/
    public static void selectSort(int[] nums){
        int size = nums.length;
        int min,in,out;
        //外层循环从 0 开始，到 倒数第二个数据
        for(out = 0;out < size-1;out++){
            min = out;//最小值默认是第一个开始遍历的数据
            //内层循环从 外层循环的下一个数据开始，到 最后一个数据
            for(in = out+1;in < size;in++){
                //如果比最小的数据小，就将 min 指向 这个最小的数据位置
                if(nums[in] < nums[min]){
                    min = in;
                }
            }
            //交换最小的数据 和 最外层数据
            int temp = nums[out];
            nums[out] = nums[min];
            nums[min] = temp;
        }
    }

    /**
      * @Author yixiu
      * @Description 插入排序
      * @Date 18:13 2020/12/3
      * @Param
      * @return
      **/
    public static void insertSort(int[] nums){
        int size = nums.length;
        int in,out;
        //外层循环从第二个数据开始，第一次前面只有一个数据，肯定是有序的
        for(out = 1;out < size;out++){
            //将外层循环的第一个数据作为标记数据
            int temp = nums[out];
            in = out;
            //内层循环从标记数据开始向前遍历
            while(in > 0 && nums[in-1] > temp){
                nums[in] = nums[in-1];
                in--;
            }
            nums[in] = temp;
        }
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
        //bubbleSort(nums);
        //selectSort(nums);
        insertSort(nums);
        show(nums);
    }
}
