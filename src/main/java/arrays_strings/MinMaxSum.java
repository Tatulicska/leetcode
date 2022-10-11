package arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

public class MinMaxSum {

  public static void main(String[] args) {
//    List<String> list = new ArrayList<>();
//    list.add("9 7 50");
//    list.add("22 7 20");
//    list.add("33 7 50");
//    list.add("22 7 30");
//    System.out.println(processLogs(list, 3));
    miniMaxSum(Arrays.asList(426980153,354802167,142980735,968217435,734892650));

  }
  public static void miniMaxSum(List<Integer> arr) {
    long maxSum = 0;
    long minSum = 0;

    long max = 0;
    long min = Long.MAX_VALUE;

    for(long val : arr){
      if(val >= max){
        max = val;
      }
      maxSum+=val;
      if(val < min){
        min = val;
      }
      minSum+=val;
    }
    System.out.printf("%s %s",minSum-min,maxSum-max);

  }


  public static List<String> processLogs(List<String> logs, int threshold) {
    Map<String, Integer> mapOdIds= new HashMap<>();
    for(String log: logs){
      String[] split =  log.split(" ");
      for(int i = 0; i< 2; i++){
        if(mapOdIds.containsKey(split[i])){
          if(i == 0 && Objects.equals(split[i], split[i + 1])){
            mapOdIds.put(split[i], mapOdIds.get(split[i])+1);
            break;
          }
          mapOdIds.put(split[i], mapOdIds.get(split[i])+1);
        } else{
          mapOdIds.put(split[i], 1);
        }
      }

    }
    mapOdIds.entrySet().removeIf(el -> el.getValue() <threshold);
    return mapOdIds.keySet().stream().sorted().map(String::valueOf).collect(Collectors.toList());

  }


}
