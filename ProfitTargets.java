import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


class Result {

    /*
     * Complete the 'stockPairs' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY stocksProfit
     *  2. LONG_INTEGER target
     */

    public static int stockPairs(List<Integer> stocksProfit, long target) {
        
        Map<Integer, Integer> map = new HashMap<>();
        Set<String> pairs = new HashSet<>();
        
        // add all elements and their frequency to a map: 
        for(int i : stocksProfit){
            map.put(i, map.getOrDefault(i, 0)+1);
        }
        
        int count = 0;
        // we want to loop through each number and identify it's compliment
        for(int profit : stocksProfit){
            String pair;
            int compliment = (int)(target - profit);
            if(map.containsKey(compliment)){
                if((compliment !=profit && map.get(profit)>0) || (compliment==profit && map.get(profit)>1)){
                    pair = Math.min(profit, compliment) + ":" + Math.max(profit, compliment);
                    //check if pair exists, if not add it and increment counter: 
                    if(!pairs.contains(pair)){
                        count++;
                        pairs.add(pair);
                    }
                    map.put(profit,map.get(profit)-1);
                    map.put(compliment,map.get(compliment)-1);


                }
            }
            
            
            
        }
    

        return count;
    }

}
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int stocksProfitCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> stocksProfit = IntStream.range(0, stocksProfitCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        long target = Long.parseLong(bufferedReader.readLine().trim());

        int result = Result.stockPairs(stocksProfit, target);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
