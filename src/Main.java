
import az.adil.science.math.ShuntingYard;
import java.util.Arrays;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


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
        
        System.out.println(sy.evaluate("7222*2+2*(3+9)+2*(((2+1*3)-(2-1)*2)+3)"));

        
    }

    

}
