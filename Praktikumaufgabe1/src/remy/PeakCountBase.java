package remy;
import java.util.stream.Stream;


public class PeakCountBase {
    
private static int valuesUsed = 0;

    
private static int[] values;

    
public static int nextValue() {
        
return valuesUsed < values.length? values[valuesUsed++]: -1;
    }

    
public static void setup(String... args) {
        
valuesUsed = 0;
        
values = Stream.of(args)
.filter(string -> !string.isEmpty())
.map(Integer::parseInt)
.mapToInt(Integer::intValue)
.toArray();
    }


}