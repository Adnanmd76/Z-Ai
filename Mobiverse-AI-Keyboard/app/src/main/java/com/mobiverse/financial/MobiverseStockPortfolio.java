package com.mobiverse.financial;

import android.os.Bundle;
import com.mobiverse.MobiVerse.R;
import com.mobiverse.ui.BaseAIActivity;

// صرف BaseAIActivity کو ایکسٹینڈ کریں
public class MobiverseStockPortfolio extends BaseAIActivity { 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // یہ عام لے آؤٹ کال کرے گا، لیکن BaseAIActivity خود بخود اس پر AI بٹن لگا دے گا
        setContentView(R.layout.activity_stock_portfolio); 
        
        // ... باقی اسٹاک کا کوڈ ...
    }
}
