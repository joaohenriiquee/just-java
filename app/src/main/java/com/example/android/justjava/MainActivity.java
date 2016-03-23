package com.example.android.justjava;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

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
        displayPrice(quantity * price);
    }

    /**
     * This method increases the amount of one and displays the value on the screen.
     */
    public void submitIncrement(View view) {
        quantity += 1;
        display();
    }

    /**
     * This method reduces the amount of one and displays the value on the screen.
     */
    public void submitDecrement(View view) {
        if (quantity > 1) {
            quantity -= 1;
            display();
        }
    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display() {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        if (quantityTextView != null) {
            String number = Integer.toString(quantity);
            quantityTextView.setText(number);
        }
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        if (priceTextView != null) {
            priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
        }
    }
}