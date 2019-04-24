package com.example.throwcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int scoredCount = 0;
    int missedCount = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display();
    }

    public void scoredClicked(View view) {
        scoredCount += 1;
        display();
    }

    public void missedClicked(View view) {
        missedCount += 1;
        display();
    }

    public void scoredMinusClicked(View view) {
        if (scoredCount != 0) {
            scoredCount += -1;
            display();
        }
    }

    public void missedMinusClicked(View view) {
        if (missedCount != 0) {
            missedCount += -1;
            display();
        }
    }

    public void resetClicked(View view) {
        scoredCount = 0;
        missedCount = 0;
        display();
    }

    private double ratio(int important, int other) {
        return (double) important / ((double) important + (double) other);
    }

    private double round(double number) {
        number = Math.floor(number * 100 + 0.5) / 100;
        return number;
    }

    private void display() {
        String text;
        TextView display;
        display = findViewById(R.id.ScoredCounter);
        text = "" + scoredCount;
        display.setText(text);
        display = findViewById(R.id.MissedCounter);
        text = "" + missedCount;
        display.setText(text);
        display = findViewById(R.id.Ratio);
        text = "" + round(ratio(scoredCount, missedCount));
        display.setText(text);
    }
}