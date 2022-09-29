import java.io.IOException;
import java.util.*;

public class Query7 {
    public static Iterable<String> Query7(Iterable<FlightRecord> input) {
        HashSet<String> states = new HashSet<String>();
        HashSet<String> IAFlights = new HashSet<String>();
        HashSet<String> ret = new HashSet<String>();


        for(FlightRecord r: input){
            states.add(r.DEST_STATE_ABR); //gather all the states
        }

        for(FlightRecord r: input){
            if(r.ORIGIN_STATE_ABR.equals("IA") ){
                IAFlights.add(r.DEST_STATE_ABR); // states that can get to IA in onr flight
            }
        }

        for(String x: states){
            if(!IAFlights.contains(x)){
                ret.add(x); // removes the outliers
            }
        }


        return ret;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        Iterable<String> rs = Query7(input);
        for (String r : rs) {
            System.out.println(r);
        }
    }
}
