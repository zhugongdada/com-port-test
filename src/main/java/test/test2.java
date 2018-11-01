package test;

import org.testng.annotations.Test;

import java.util.HashMap;

/**
 * Created by Administrator on 2018/8/15.
 */
public class test2 {
    @Test(priority = 1)
    public void test9x9() {//9x9乘法口诀
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                if (j!=i) {
                    System.out.print(j + "*" + i + "=" + (j * i) + "\t");
                }else {
                    System.out.println();
                }
            }
        }
    }

    @Test(priority = 2)
    public void paixu() {//从小到大排序
        int[] arr = {12, 23, 34, 46, 45, 54};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }

    @Test(priority = 3)
    public void paixu1(){
        int[] arr = {12, 23, 34, 46, 45, 54};
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] < arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
        for (int i=0;i<arr.length;i++){
            System.out.print(arr[i]+"\t");
        }
    }

//统计字符个数
@Test
public void count(){
    String str="afd";
    char[] chars= str.toCharArray();
    HashMap<Character,Integer> hm=new HashMap();
    //循环遍历
    for (char c : chars){
        if (!hm.containsKey(c)){
            hm.put(c,1);

        }else {
            hm.put(c,hm.get(c)+1);
        }
    }
    for (Character key : hm.keySet()){
        System.out.println(key+" =======> "+hm.get(key));
    }
}
}

