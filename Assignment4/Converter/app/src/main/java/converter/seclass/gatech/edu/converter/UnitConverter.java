package converter.seclass.gatech.edu.converter;

import java.util.HashMap;

/**
 * Created by grunt on 2/15/2016.
 */
public class UnitConverter {
    private double unit;
    private String from;
    private String to;
    private HashMap<String, Double> unitRates = new HashMap<String, Double>();

    public UnitConverter(String from, String to){
        this.from = from;
        this.to = to;
        rate();
    }

    public void rate(){
        unitRates.put("Mile", 160934.0 );
        unitRates.put("Km", 100000.0 );
        unitRates.put("Feet", 30.48 );
        unitRates.put("Meter", 100.0 );
        unitRates.put("Inch", 2.54 );
        unitRates.put("cm", 1.0 );
        this.unit = unitRates.get(from)/unitRates.get(to);
    }

    public double getUnitConvert(){
        return this.unit;
    }
}
