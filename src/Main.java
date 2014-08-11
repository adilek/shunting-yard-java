
import az.adil.science.math.ShuntingYard;

/**
 *
 * @author adil
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        
        ShuntingYard sy = new ShuntingYard();
        
        System.out.println(sy.evaluate("78+3+3+6*(3+4*(3+4))"));

        
    }

    

}
