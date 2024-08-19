package arrays;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7};
        int arraySize = prices.length;

        int maxProfit = searchAndFindMaxProfitBetterSolution(prices,arraySize);

        System.out.println("Max Profit in given prices is: " + maxProfit);
    }

    // Time Complexity O(n2)
    // Space Complexity O(1)
    static int searchAndFindMaxProfitBruteForce(int[] prices, int arraySize) {
        int MAX_PROFIT = 0;

        for(int i=0; i<arraySize-1; i++) {
            //outer loop will have buying price of stock
            int currentPrice = prices[i];
            for(int j = i+1; j<arraySize; j++) {
                // if buy price is higher than other days then skip that
                if(currentPrice > prices[j])
                    continue;

                // get the max profit
                MAX_PROFIT = Math.max(prices[j] - currentPrice,MAX_PROFIT);
            }
        }

        return MAX_PROFIT;
    }

    // time complexity O(n)
    // Space Complexity O(1)
    static int searchAndFindMaxProfitBetterSolution(int[] prices, int arraySize) {
        int MAX_PROFIT = 0;
        //initial price i.e. buying on day 1
        int buyPrice = prices[0];

        for(int i=1; i<arraySize; i++) {
            // if there is lower value than buying price
            // then buy that stock and update the buyPrice
            if(buyPrice > prices[i]) {
                buyPrice = prices[i];
            } else {
                // calculate the max profit
                MAX_PROFIT = Math.max(prices[i] - buyPrice, MAX_PROFIT);
            }
        }

        return MAX_PROFIT;
    }
}
