package net.hubicreations.knifflig;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener, TextView.OnTouchListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initNumSpinner(R.id.onesSpinner);
        initNumSpinner(R.id.twosSpinner);

        textView = (TextView) findViewById(R.id.playerOneOnesTextView);
        textView.setOnTouchListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


    public void initNumSpinner(int pId) {
        Spinner spinner = (Spinner) findViewById(pId);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.spinner_values, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // required so that onItemSelected is not called when initializing
        spinner.setAdapter(adapter);
        spinner.setSelection(0, false);

        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Integer itemAtPosition = position;
        itemAtPosition *= 2;
        textView.setText(itemAtPosition.toString());
        textView.setVisibility(View.VISIBLE);
        findViewById(R.id.onesSpinner).setVisibility(View.GONE);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        textView.setVisibility(View.GONE);
        findViewById(R.id.onesSpinner).setVisibility(View.VISIBLE);
        return true;
    }
}

