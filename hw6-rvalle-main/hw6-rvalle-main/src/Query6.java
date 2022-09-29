import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Query6 {
    public static String Query6(Iterable<FlightRecord> input) {
        Map<String, Integer> flights = new TreeMap<>();
        int max = 0;
        String ret = ""; // tree map, max counter, and a return string

        for (FlightRecord r : input) {
            String origin = r.ORIGIN_STATE_ABR;
            String dest = r.DEST_STATE_ABR;
            String states = ""; // origin, destination and string to combine them

            if(origin.compareTo(dest) <=0){
                states = origin + "," + dest; // this is a check for the alphabetical order
            } // if the origin is less, it comes first alphabetically
            else{
                states = dest + "," + origin; // otherwise dest, origin
            }

            if(flights.containsKey(states)){ // now checking and comparing the keys
                flights.put(states, flights.get(states) + 1); // if the key exists one is added

                if(max < flights.get(states)){
                    max = flights.get(states);
                    ret = states; // now I check if the current pair is greater than the max and replace it if it is
                }

            }
            else{
                flights.put(states, 1); // if key does not exist count starts at one
            }

        }


        return ret;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query6(input);
        System.out.println(r);
    }
}
