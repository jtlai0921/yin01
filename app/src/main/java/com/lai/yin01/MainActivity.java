package com.lai.yin01;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
private int mQuantity=0;
    private int mPrice=5;
    private TextView mQuantityTextView;
    private TextView mTotalPriceTextView;
    private StringBuilder mTotalPriceString=new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuantityTextView=findViewById(R.id.quantity_text_view);
        mTotalPriceTextView=findViewById(R.id.quantity_text_view);
    }
    public void submitOrder(View view){
        displayTotalPrice();
    }

    private void displayTotalPrice() {

        int total=mPrice*mQuantity;
       int end=mTotalPriceString.length();
       mTotalPriceString.delete(0,end);
       mTotalPriceString.append("NT$").append(total);
       mTotalPriceString.append(mQuantity==0?"\nFree":"\nThank you!");
       mQuantityTextView.setText(mTotalPriceString);
    }

    private void display(int number) {
        mQuantityTextView.setText(String.valueOf(number));
    }

    public void increment(View view){
        display(++mQuantity);
    }
    public void decrement(View view){
        display(--mQuantity);
    }
}
