/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoffeeMachine;

import java.util.HashMap;
import java.util.Map;
import javax.security.auth.login.Configuration;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class BasicCoffeeMachine implements FilterCoffeMachine {

    private GroundCoffee groundCoffee;
    private Map<CoffeeSelection, Configuration> configMap;
    private BrewingUnit brewingUnit;

    public BasicCoffeeMachine(GroundCoffee groundCoffee) {
        this.groundCoffee = groundCoffee;
        this.brewingUnit = new BrewingUnit();

        this.configMap = new HashMap<>();
    }

    @Override
    public CoffeeDrink brewFilterCoffee() throws CoffeeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void addGroundCoffee(GroundCoffee newCoffee) throws CoffeeException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
