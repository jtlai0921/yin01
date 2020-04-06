package com.lai.yin01;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
public class MainActivity extends Activity {
    private int mQuantity=0;
    private int mPrice=5;
    private TextView mQuantityTextView;
    private TextView mOrderSummaryTextView;
    private TextView mTotalPriceTextView;
    private CheckBox mtoppingscheckbox;
    private StringBuilder mTotalPriceString=new StringBuilder();
    private boolean 加酒精;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mQuantityTextView=findViewById(R.id.quantity_text_view);
        mTotalPriceTextView=findViewById(R.id.price_text_view);
        mOrderSummaryTextView = findViewById(R.id.order_summary_text_view);
        mtoppingscheckbox=findViewById(R.id.toppings_checkbox);
    }
    public void submitOrder(View view){

        displayTotalPrice();
    }
    public void increment(View view){
        if(mQuantity<=3)
        {
            display(++mQuantity);
        }

    }
    public void decrement(View view){
        if(mQuantity<=1)
        {
            display(mQuantity=1);
        }
        display(--mQuantity);
    }
    private void display(int number) {
        mQuantityTextView.setText(String.valueOf(number));
    }
    private void resetMessage(){
        int len=mTotalPriceString.length();
        mOrderSummaryTextView.setText("price");
        mTotalPriceTextView.setText("NT$5");
    }
    private void displayTotalPrice() {
        int total=mPrice*mQuantity;
        mOrderSummaryTextView.setText("order");
        mTotalPriceString.append("123\n").append("口罩\n").append("加酒精\n").append(加酒精);
        if(mQuantity>0){
            mTotalPriceString.append("\nQuantity: ").append(mQuantity).append("\nTotal: ").append("NT$:").append(total);
        }
        mTotalPriceString.append(mQuantity==0?"\nFree":"\nThank you!");
        mQuantityTextView.setText(mTotalPriceString);
    }
    public void clickTopping(View view){
       if (mtoppingscheckbox.isChecked()){
           加酒精=true;
       }else {
           加酒精=false;
       }
    }
public void clickManager(View view){
        resetMessage();
        int id=view.getId();
        switch (id){

            case R.id.toppings_checkbox:
            clickTopping(view);
            break;
            case R.id.btn_inc:
                increment(view);
                break;
            case R.id.btn_dec:
                decrement(view);
                break;
            case R.id.btn_order:
                submitOrder(view);
                break;
        }
}
}
