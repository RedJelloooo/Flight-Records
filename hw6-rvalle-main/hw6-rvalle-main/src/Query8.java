import java.io.IOException;
import java.text.DecimalFormat;
import java.util.*;

public class Query8 {
    public static Iterable<String> Query8(Iterable<FlightRecord> input) {
        Map<String, Integer[]> totalFlights = new TreeMap<>();
        Set<String> ret = new HashSet<>();

        for(FlightRecord r: input){
            int interstate;
            String state = r.ORIGIN_STATE_ABR;

            if(state.equals(r.DEST_STATE_ABR)) {
                interstate = 1;
            }
            else{
                interstate = 0; // checking if the flight is interstate
            }

            Integer[] flight; // to store both total and interstate flights

            if(totalFlights.containsKey(state)){
                flight = totalFlights.get(state);

                flight[0] = flight[0] + interstate; // is only added if the flight is interstate
                flight[1] = flight[1] + 1; // adds all flights
            }

            else{
                flight = new Integer[]{interstate, 1}; // creates new entry
            }

            totalFlights.put(state, flight); // adds the flight to the treemap
        }

        for(String state: totalFlights.keySet()){

            Integer[] calc = totalFlights.get(state);
            int interstateFlights = calc[0];
            int allFlights = calc[1]; //this is the calculation to get the comparison

            float y = (float)interstateFlights/allFlights;
            DecimalFormat df = new DecimalFormat("#.000");
            String withThreeDigits = df.format(y); // copied from the query 8 instructions

            if(!withThreeDigits.equals(".000")){ // removes entry of all 0's
                ret.add(state + "=" + withThreeDigits); //adds to hashmap
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        Iterable<String> rs = Query8(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
