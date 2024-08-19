package arrays;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        int[] prices = {10,1,5,6,7,1};
        int arraySize = prices.length;

        int maxProfit = searchAndFindMaxProfitBruteForce(prices,arraySize);

        System.out.println("Max Profit in given prices is: " + maxProfit);
    }

    // Time Complexity O(n2)
    // Space Complexity O(1)
    static int searchAndFindMaxProfitBruteForce(int[] prices, int arraySize) {
        int MAX_PROFIT = 0;

        for(int i=0; i<arraySize-1; i++) {
            int currentPrice = prices[i];
            for(int j = i+1; j<arraySize; j++) {
                if(currentPrice > prices[j])
                    continue;

                MAX_PROFIT = Math.max(prices[j] - currentPrice,MAX_PROFIT);
            }
        }

        return MAX_PROFIT;
    }
}
