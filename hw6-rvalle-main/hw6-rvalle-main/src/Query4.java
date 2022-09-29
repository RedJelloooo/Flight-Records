import java.io.IOException;
import java.util.*;

public class Query4 {

    public static Iterable<String> Query4(Iterable<FlightRecord> input) {
        HashSet<String> flights = new HashSet<String>();
        int tempC = 0;

        for (FlightRecord r : input) {
            if (r.ORIGIN.equals("CID")){
                for(FlightRecord s: input){
                    if(s.ORIGIN.equals("CID") && s.DEST.equals(r.DEST)){
                        tempC++;
                    }
                }

                flights.add(r.DEST + "=" + tempC);
            }
            tempC = 0;
        }
        return flights;

    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights2005.csv");
        Iterable<String> results = Query4(input);
        for (String s : results) {
            System.out.println(s);
        }
    }
}
