import java.io.IOException;
import java.util.*;

public class Query9 {
    public static Iterable<String> Query9(Iterable<FlightRecord> input) {
        Map<String, Map<String, Integer>> flights = new HashMap<>();
        //this is a map that includes the state, airline, and then the number of flights within the state
        Set<String> ret = new HashSet<>(); // return Iterable

        for(FlightRecord r: input){
            String carrier = r.UNIQUE_CARRIER_NAME;
            String DEST = r.DEST_STATE_ABR; // sets the carrier and destination

            if(flights.containsKey(DEST)){
                if(flights.get(DEST).containsKey(carrier)){
                    flights.get(DEST).put(carrier, flights.get(DEST).get(carrier)+1);
                } // if they carrier exists one is added with number of flights into the state
                else{
                    flights.get(DEST).put(carrier, 1);
                } // key is created if carrier does not exist

            }

            else{
                Map<String, Integer> setter = new HashMap<>();
                setter.put(carrier, 1);
                flights.put(DEST, setter); // if state does not exist
            }
        }

        int max = 0;
        String stringMax = "";
        for(String x: flights.keySet()){
            max = 0;
            stringMax = ""; // here the variables created are resetted
            for(String y: flights.get(x).keySet()){
                if( max <= flights.get(x).get(y)){
                    stringMax = y;
                    max = flights.get(x).get(y); // comparison
                }
            }

            ret.add(x + "," + stringMax); // final addition
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> rs = Query9(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
