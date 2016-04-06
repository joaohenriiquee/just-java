package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0; /* Variable with value of quantity. */
    int price = 5; /* Variable with value of price. */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculePrice();
        displayMessage(createOrderSummary(price));
    }

    /**
     * This method return total price.
     *
     * @return priceTotal
     */
    public int calculePrice(){
        return quantity * price;
    }

    /**
     * This method increases the amount of one and displays the value on the screen.
     */
    public void submitIncrement(View view) {
        quantity += 1;
        displayQuant();
    }

    /**
     * This method reduces the amount of one and displays the value on the screen.
     */
    public void submitDecrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            displayQuant();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void displayQuant() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if (quantityTextView != null) {
            String number = Integer.toString(quantity);
            quantityTextView.setText(number);
        }
    }

    /**
     * This method displays the given price on the screen.
     *
     * @param Message of the price.
     */
    private void displayMessage(String Message) {
        TextView orderSummaryTextView = (TextView) findViewById(R.id.order_summary_text_view);
        if (orderSummaryTextView != null) {
            orderSummaryTextView.setText(Message);
        }
    }

    /**
     * This method displays a message on the screen.
     *
     * @param price of the price.
     */
    private String createOrderSummary(int price){
        String name = "João Henrique";
        return "Name: "+name+"\nQuantity: "+quantity+"\nTotal: $"+price+"\nThank You!";
    }
}