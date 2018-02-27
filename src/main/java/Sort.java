import java.util.Arrays;

/**
 * 排序
 */
public class Sort {


    /**
     * 冒泡排序 平均时间复杂度(O(n2))
     * 1.比较相邻的两个数据，如果第二个数小，就交换位置。
     * 2.从前向后两两比较，一直到比较最后两个数据。最终最大数被交换到最后的位置，这样第一个最大数的位置就排好了。
     * 3.继续重复上述过程，依次将第1.2.3...n-2个最小数排好位置。
     * @param arr
     */
    public static void bubbleSort(int[] arr){

        //外层控制排序次数
        for(int j=1; j<arr.length; j++){
            //单趟排序
            for(int i=0; i<arr.length-j; i++){
                if(arr[i]>arr[i+1]){
                    int temp = arr[i];
                    arr[i] = arr[i+1];
                    arr[i+1] = temp;
                }
            }
        }

    }

    /**
     * 选择排序 平均时间复杂度(O(n2))
     * 在长度为N的无序数组中，第一次遍历n-1个数，找到最小的数值与第一个元素交换；
     * 第二次遍历n-2个数，找到最小的数值与第二个元素交换；
     * 。。。
     * 第n-1次遍历，找到最小的数值与第n-1个元素交换，排序完成。
     * @param arr
     */
    public static void selctionSort(int[] arr){

        for(int j=0; j<arr.length-1; j++){
            //查找最小的元素
            int minIndex = j;
            for(int i=j+1; i<arr.length; i++){
                if(arr[minIndex] > arr[i]){
                    minIndex = i;
                }
            }
            //交换
            if(minIndex != j){
                int temp = arr[minIndex];
                arr[minIndex] = arr[j];
                arr[j] = temp;
            }
        }
    }

    /**
     * 插入排序 平均时间复杂度(O(n2))
     * 在要排序的一组数中，假定前n-1个数已经排好序，现在将第n个数插到前面的有序数列中，使得这n个数也是排好顺序的。
     * 如此反复循环，直到全部排好顺序。
     * @param arr
     */
    public static void insertionSort(int[] arr){
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j>0; j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                } else{
                    break;
                }
            }
        }
    }

    /**
     * 快速排序 时间复杂度(O(N*logN))
     * 1.先从数列中取出一个数作为key值；
     * 2.将比这个数小的数全部放在它的左边，大于或等于它的数全部放在它的右边；
     * 3.对左右两个小数列重复第二步，直至各区间只有1个数。
     * @param arr
     * @param low
     * @param hight
     */
    public static void quickSort(int[] arr, int low, int hight){
        if(low>hight){
            return;
        }
        int i = low, j = hight, index = arr[i];//index为基准
        while(i<j){ //从表的两端交替向中间扫描
            while(i<j && arr[j]>=index){
                j--;
            }
            if(i<j){
                arr[i++] = arr[j]; //用比基准小的记录替换低位记录
            }
            while(i<j && arr[i]<index){
                i++;
            }
            if(i<j){
                arr[j--] = arr[i]; //用比基准大的记录替换高位记录
            }
        }
        arr[i] = index; //将基准数值替换回arr[i]
        quickSort(arr, low, i - 1); // 对低子表进行递归排序
        quickSort(arr, i + 1, hight); // 对高子表进行递归排序
    }

    public static void main(String[] args){
        int[] arr = {9,8,7,10,5,4};
        quickSort(arr, 0, 5);
        System.out.println(Arrays.toString(arr));
    }
}
