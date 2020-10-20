import java.util.Arrays;

/**
 * Created With IntelliJ IDEA.
 * Description:
 * User:ZouSS
 * Date:2020-10-20
 * Time:18:45
 **/
public class TestSort {

    //每做一次partition，时间复杂度O(n)
    //一共多少层，看二叉树高度
    //二叉树一般是log(n)，最坏n
    //所以，最好实践复杂度：O(log(n))
    //最坏O（n^2)
    //空间复杂度：最好O（log(n))  最坏：O(n^2)

    //快排过程：
    //1、选择一个数（放在最左边）
    //2、做partition操作（大的数字放右边，小的放在右面）
    //3、重复整个过程
    //4、直至当前的数组的个数=0或者=1
    private static void quickSortInternal(int[] array,int lowIndex,int highIndex){
        //选择其中一个数（选择最左边的)——array[low]
        int size = highIndex-lowIndex+1;
        if (size <= 1){
            return;
        }
        int keyIndex = partition(array,lowIndex,highIndex);
        quickSortInternal(array,lowIndex,keyIndex-1);
        quickSortInternal(array,keyIndex+1,highIndex);
    }
    private static int partition(int[] array,int lowIndex,int highIndex){
        //1、Hover法
        int ret = partitionHover(array,lowIndex,highIndex);
        return ret;

    }
    private static int partition挖坑法(int[] array,int lowIndex,int highIndex){
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        int key = array[lowIndex];

        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] >= key){
                rightIndex--;
            }
            array[leftIndex] = array[rightIndex];
            while(leftIndex < rightIndex && array[leftIndex] <= key ){
                leftIndex++;
            }

            array[rightIndex] = array[leftIndex];
        }
        array[leftIndex] = key;
        return leftIndex;
    }
    private static void swap(int[] array,int index1,int index2){
        int tmp = array[index1];
        array[index1] = array[index2];
        array[index2] = tmp;
    }
    private static int partitionHover(int[] array,int lowIndex,int highIndex){
        int leftIndex = lowIndex;
        int rightIndex = highIndex;
        int key = array[leftIndex];
        while(leftIndex < rightIndex){
            while(leftIndex < rightIndex && array[rightIndex] >= key ){
                rightIndex--;
            }
            while(leftIndex < rightIndex && array[leftIndex] <= key ){
                leftIndex++;
            }
            swap(array,array[leftIndex],array[rightIndex]);
        }
        swap(array,array[lowIndex],array[leftIndex]);
        return leftIndex;
    }
    public static void quickSort(int[] array){
        quickSortInternal(array,0,array.length);
    }

    public static void main(String[] args) {
        int[] array = {2,3,4,5,6,6,7,8};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
}
