package converter.seclass.gatech.edu.converter;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class ConverterActivity extends AppCompatActivity {
    private RadioButton rbFromMile;
    private RadioButton rbFromKm;
    private RadioButton rbFromFeet;
    private RadioButton rbFromMeter;
    private RadioButton rbFromInch;
    private RadioButton rbFromCm;
    private RadioButton rbToMile;
    private RadioButton rbToKm;
    private RadioButton rbToFeet;
    private RadioButton rbToMeter;
    private RadioButton rbToInch;
    private RadioButton rbToCm;
    private EditText distValue;
    private EditText distResult;

    private List<RadioButton> rbFrom = new ArrayList<RadioButton>();
    private List<RadioButton> rbTo = new ArrayList<RadioButton>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        rbFromMile = (RadioButton) findViewById(R.id.rbFromMile);
        rbFrom.add(rbFromMile);
        rbFromKm = (RadioButton) findViewById(R.id.rbFromKm);
        rbFrom.add(rbFromKm);
        rbFromFeet = (RadioButton) findViewById(R.id.rbFromFeet);
        rbFrom.add(rbFromFeet);
        rbFromMeter = (RadioButton) findViewById(R.id.rbFromMeter);
        rbFrom.add(rbFromMeter);
        rbFromInch = (RadioButton) findViewById(R.id.rbFromInch);
        rbFrom.add(rbFromInch);
        rbFromCm = (RadioButton) findViewById(R.id.rbFromCm);
        rbFrom.add(rbFromCm);
        rbToMile = (RadioButton) findViewById(R.id.rbToMile);
        rbTo.add(rbToMile);
        rbToKm = (RadioButton) findViewById(R.id.rbToKm);
        rbTo.add(rbToKm);
        rbToFeet = (RadioButton) findViewById(R.id.rbToFeet);
        rbTo.add(rbToFeet);
        rbToMeter = (RadioButton) findViewById(R.id.rbToMeter);
        rbTo.add(rbToMeter);
        rbToInch = (RadioButton) findViewById(R.id.rbToInch);
        rbTo.add(rbToInch);
        rbToCm = (RadioButton) findViewById(R.id.rbToCm);
        rbTo.add(rbToCm);
        distValue = (EditText) findViewById(R.id.distValue);
        distResult = (EditText) findViewById(R.id.distResult);
    }

    public void handleClick(View view){
        String unitFrom = "Mile";
        String unitTo = "Mile";

        switch (view.getId()){

            case R.id.buttonConvert:
                String value = distValue.getText().toString();
                if (value.length()>0){
                    for (RadioButton button:rbFrom){
                        if (button.isChecked()){
                            unitFrom = button.getText().toString();
                            break;
                        }
                    }
                    for (RadioButton button:rbTo){
                        if (button.isChecked()){
                            unitTo = button.getText().toString();
                            break;
                        }
                    }
                    if (unitFrom.contentEquals(unitTo)){
                        distResult.setText(value);
                    }
                    else{
                        UnitConverter rate = new UnitConverter(unitFrom, unitTo);
                        double convertRate = rate.getUnitConvert();
                        distResult.setText(calculator(value,convertRate));
                    }

                }
                else{
                    Context context = getApplicationContext();
                    CharSequence text = "Empty value!";
                    int duration = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                }
                break;

            case R.id.buttonReset:
                distValue.setText("");
                distResult.setText("");
                rbFromMile.setChecked(true);
                rbToMile.setChecked(true);
                break;
        }
    }

    public String calculator(String input, double rate){
        double distance = Double.parseDouble(input);
        double output = distance*rate;
        DecimalFormat format = new DecimalFormat("#.##");
        return String.valueOf(format.format(output));
    }
}
