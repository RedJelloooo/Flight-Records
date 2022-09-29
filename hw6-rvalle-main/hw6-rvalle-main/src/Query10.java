import java.io.IOException;
import java.util.*;

public class Query10 {

    public static Iterable<String> Query10(Iterable<FlightRecord> input) {
        Map<String, String> flightOne = new HashMap<>(); // this map stores all departing flights
        Map<String, String> flightTwo = new HashMap<>(); // this map stores all the arriving flights
        Set<String> ret = new HashSet<>(); // set to return finished product

        for(FlightRecord r: input ) {

            if (r.ORIGIN.equals("CID")) {
                flightOne.put(r.DEST, r.ORIGIN); // this loop goes through and adds the first section of flights
            }

        }

        for(FlightRecord r: input){

            if(r.DEST.equals("LAX")){
                flightTwo.put(r.ORIGIN, r.DEST); // this loop goes through and adds the flights arriving to LAX
            }

        }

        for(String x: flightOne.keySet()){
            if(flightTwo.containsKey(x)){ // if the connecting flights contain the matching pair it is added to the return Set
                ret.add("CID->" + x + "->LAX");
            }
        }

        return ret;
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2020.csv");
        Timer t = new Timer();
        t.start();
        Iterable<String> results = Query10(input);
        t.end();
        for (String s : results) {
            System.out.println(s);
        }
        System.out.println(t.elapsedSeconds());
    }
}
