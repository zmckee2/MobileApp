package com.example.javaguifun;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.Toast;

public class MyGridLayout extends GridLayout {
    private final int n = 3;
    public MyGridLayout(final Context context) {
        super(context);
        //Context is a reference to the current activity
        //Everything done in xml can be done in Java

        setBackgroundColor(Color.BLACK);
        setColumnCount(n);

        Button myButton = new Button(context);
        myButton.setText("Button 1");

        //How to set width to match_parent instead of wrap_content
//        GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
//        layoutParams.width = layoutParams.WRAP_CONTENT;
//        layoutParams.height = layoutParams.WRAP_CONTENT;
//        myButton.setLayoutParams(layoutParams);
        //addView(myButton); //<-- how to add a new view to the layout
        View.OnClickListener listner = new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Button b = (Button) v;
                Toast.makeText(context, "HI", Toast.LENGTH_SHORT).show();

            }
        };
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++){
                Button b = new Button(context);
                b.setText(i+" " + j);

                // to get row weights, use a spec
                // GridLayout.Spec and GridLayout.spec()
                // for spans and weights
                GridLayout.Spec rowSpec = GridLayout.spec(i, 1, 1);
                //row start index, row span, row weight
                GridLayout.Spec columnSpec = GridLayout.spec(j,1,1);
                GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams(rowSpec, columnSpec);
                b.setLayoutParams(layoutParams);
                b.setOnClickListener(listner);

                addView(b);
            }
    }

}
