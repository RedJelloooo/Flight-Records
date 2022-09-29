import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class Query5 {
    public static String Query5(Iterable<FlightRecord> input) {

        int max = 0;
        int month =0;
        int tempMax = 0;

        for(FlightRecord r : input) {
            if(r.MONTH == 1) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 1;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 2) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 2;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 3) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 3;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 4) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 4;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 5) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 5;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 6) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 6;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 7) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 7;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 8) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 8;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 9) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 9;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 10) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 10;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 11) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 11;
            }
        }

        tempMax = 0;
        for(FlightRecord r : input) {
            if(r.MONTH == 12) {
                tempMax += 1;
            }
            if(tempMax > max){
                max = tempMax;
                month = 12;
            }
        }

        //im sorry this was the only way I could get it to work
        return (month + " had " + max + " flights");
    }

    public static void main(String[] args) throws IOException {
        Iterable<FlightRecord> input = DataImporter.getData("flights1990.csv");
        String r = Query5(input);
        System.out.println(r);
    }
}
