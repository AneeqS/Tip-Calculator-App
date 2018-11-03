package com.aneeqshah.tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Context;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculatorActivity extends AppCompatActivity {


    public void tipButton(View view){
        //Connects the editTexts by their id
        EditText checkAmountText = findViewById(R.id.checkAmountValue);
        EditText partySizeText = findViewById(R.id.partySizeValue);

        //Converts to a string.
        String checkAmountS = checkAmountText.getText().toString();
        String partySizeS = partySizeText.getText().toString();

        //Checks if the string entered is empty, then gives a warning
        if(checkAmountS.matches("") || partySizeS.matches("")){
            Toast.makeText(this, "Values Cannot be EMPTY!", Toast.LENGTH_LONG).show();
        }
        else {
            double checkAmountValue = Double.parseDouble(checkAmountS);
            //double partySizeValue = Double.parseDouble(partySizeS);
            int partySizeValue = Integer.parseInt(partySizeS);

            //Checks for an Invalid input
            if(checkAmountValue <= 0 || partySizeValue <= 0){
                Toast.makeText(this, "Values Cannot be NEGATIVE! or ZERO", Toast.LENGTH_LONG).show();
                closeKeyboard();
                return;
            }

            //Calculates the tip and the total value.
            int fifteenTip = (int) Math.round(((checkAmountValue * 0.15)) / partySizeValue);
            int fifteenTotal = (int) Math.round((checkAmountValue / partySizeValue) + fifteenTip);
            int twentyTip = (int) Math.round(((checkAmountValue * 0.20)) / partySizeValue);
            int twentyTotal = (int) Math.round((checkAmountValue / partySizeValue) + twentyTip);
            int twentyFiveTip = (int) Math.round(((checkAmountValue * 0.25)) / partySizeValue);
            int twentyFiveTotal = (int) Math.round((checkAmountValue / partySizeValue) + twentyFiveTip);


            //Coverts the int to a string to be displayed to the user.
            String fifteenTipText = Integer.toString(fifteenTip);
            String fifteenTotalText = Integer.toString(fifteenTotal);
            String twentyTipText = Integer.toString(twentyTip);
            ;
            String twentyTotalText = Integer.toString(twentyTotal);
            ;
            String twentyFiveTipText = Integer.toString(twentyFiveTip);
            ;
            String twentyFiveTotalText = Integer.toString(twentyFiveTotal);
            ;

            //Sets the string to a text field that can be displayed to the user.
            TextView fifteenTipValue = findViewById(R.id.fifteenPercentTipValue);
            fifteenTipValue.setText(fifteenTipText);

            TextView fifteenTotalValue = findViewById(R.id.fifteenPercentTotalValue);
            fifteenTotalValue.setText(fifteenTotalText);

            TextView twentyTipValue = findViewById(R.id.twentyPercentTipValue);
            twentyTipValue.setText(twentyTipText);

            TextView twentyTotalValue = findViewById(R.id.twentyPercentTotalValue);
            twentyTotalValue.setText(twentyTotalText);

            TextView twentyFiveTipValue = findViewById(R.id.twentyfivePercentTipValue);
            twentyFiveTipValue.setText(twentyFiveTipText);

            TextView twentyFiveTotalValue = findViewById(R.id.twentyfivePercentTotalValue);
            twentyFiveTotalValue.setText(twentyFiveTotalText);



        }

        //Closes the keyboard when the button is pressed
        closeKeyboard();

        Log.i("Check Amount", checkAmountText.getText().toString());
        Log.i("Party Size", partySizeText.getText().toString());
        Log.i("Info", "Button Pressed");
    }


    public void closeKeyboard(){
        View view1 = this.getCurrentFocus();
        if (view1 != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view1.getApplicationWindowToken(), 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
