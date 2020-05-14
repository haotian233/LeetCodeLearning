//用hashmap实现，时间复杂度为n 空间复杂度为n
public int singleNumber_0(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (Integer i : nums) {
            Integer count = map.get(i);
            count = count == null ? 1 : ++count;
            map.put(i, count);
        }
        for (Integer i : map.keySet()) {
            Integer count = map.get(i);
            if (count == 1) {
                return i;
            }
        }
        return -1; // can't find it.
    }
    /*
    使用位运算。对于这道题，可使用异或运算⊕。异或运算有以下三个性质
    1.任何数和 0 做异或运算，结果仍然是原来的数，即a⊕0=a
    2.任何数和其自身做异或运算，结果是 0，即 a⊕a=0
    3.异或运算满足交换律和结合律
    数组中的全部元素的异或运算结果即为数组中只出现一次的数字
    /*
public int singleNumber_1(int[] nums) {
    int single = 0;
    for (int num : nums) {
        single ^= num;
    }
    return single;
}


/*
nor(异或)去掉出现偶数次的数字
用两个标志位（seenTwice seenOnce）区分出现一次还是两次

*/
public int singleNumber_2(int[] nums) {
    int seenOnce = 0, seenTwice = 0;

    for (int num : nums) {
      // first appearence: 
      // add num to seen_once 
      // don't add to seen_twice because of presence in seen_once

      // second appearance: 
      // remove num from seen_once 
      // add num to seen_twice

      // third appearance: 
      // don't add to seen_once because of presence in seen_twice
      // remove num from seen_twice
      seenOnce = ~seenTwice & (seenOnce ^ num);
      seenTwice = ~seenOnce & (seenTwice ^ num);
    }

    return seenOnce;
  }
