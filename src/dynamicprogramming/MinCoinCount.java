package dynamicprogramming;

public class MinCoinCount {
    public static void main(String[] args) {
        int total = 11;
        int[] values = new int[]{5,3};
        //int count = getMinCoinCountGreedy(total,values,0,3);
        int count = getMinCoinCountRecursion(total,values);
        System.out.println("need coin num:" + count);
    }

    /**
     * 硬币找零：获取最小硬币数
     * 这里主要是使用回溯来优化贪心算法从局部最优解无法获取正确的整体最优解的情况
     * 虽然回溯是使用递归调用来实现的，但真正的出发点是贪心算法
     * @param total  所需硬币总值
     * @param values 硬币币种集合
     * @param valueIndex  使用硬币标记
     * @param valueCount  硬币的类型总数
     * @return
     */
    static int getMinCoinCountGreedy(int total,int[] values,int valueIndex,int valueCount) {
        if(valueIndex == valueCount){
            return -1;
        }

        int currentVal = values[valueIndex];
        System.out.println("正在使用面值为："+currentVal+" 的硬币凑数:"+total);
        int totalCount = total/currentVal;
        System.out.println("所需的硬币数："+totalCount);
        for(int count=totalCount;count>=0;count--){
            int rest = total - count*currentVal;
            System.out.println("当使用面值为"+currentVal+"的硬币数为"+count+"时，剩余的硬币总值为："+rest);
            if (rest == 0){
                return count;
            }else{
                int restCount = getMinCoinCountGreedy(rest,values,valueIndex+1,valueCount);
                if(restCount == -1){
                    if (count == 0) return -1;
                    continue;
                }
                return count + restCount;
            }
        }

        return -1;
    }

    /**
     * 硬币找零：获取最小硬币数
     * 使用递归来实现
     * @param total  所需硬币总值
     * @param values 硬币币种集合
     * @return
     */
    static int getMinCoinCountRecursion(int total,int[] values){
        System.out.println("当前所需的硬币面值为：" + total);
        if(total == 0) {
            //System.out.println("所需面值为0，返回所需的硬币数0.");
            return 0;
        }
        //System.out.println("设置最小硬币数为MAX_VALUE。");
        int minCount = Integer.MAX_VALUE;
        for(int i = 0; i < values.length;i++){
            int currentValue = values[i];
            System.out.println("当前硬币面值为："+currentValue);
            if(currentValue > total){
                //System.out.println("当前硬币面值大于所需的硬币面值，继续循环");
                continue;
            }
            int restValue = total - currentValue;
            //System.out.println("剩余硬币面值为："+restValue);
            int restCount = getMinCoinCountRecursion(restValue,values);
            //System.out.println("剩余硬币面值为："+restValue+",所需的硬币数："+restCount);
            if(restCount == -1) {
                //System.out.println("所需的硬币数：-1,当前循环废弃。");
                continue;
            }
            int totalCount = restCount + 1;
            System.out.println("面值为："+total+" 所需的硬币总数为："+totalCount);
            if(minCount > totalCount) minCount = totalCount;
            //System.out.println("设置所需的最小硬币数minCount:"+totalCount);
        }
        if(minCount == Integer.MAX_VALUE) {
            System.out.println("最小硬币数为MAX_VALUE，返回-1，当前路径废弃。");
            return -1;
        }
        System.out.println("返回所需的最小硬币数minCount:"+minCount);
        return minCount;
    }
}
