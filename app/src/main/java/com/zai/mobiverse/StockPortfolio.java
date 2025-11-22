package com.zai.mobiverse;

import java.util.HashMap;
import java.util.Map;

public class StockPortfolio {
    private Map<String, Integer> portfolio;

    public StockPortfolio() {
        this.portfolio = new HashMap<>();
    }

    public void addStock(String ticker, int shares) {
        this.portfolio.put(ticker, shares);
    }

    public Map<String, Integer> getPortfolio() {
        return portfolio;
    }
}
