/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CoffeeMachine;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public interface FilterCoffeMachine extends CoffeeMachine {

    CoffeeDrink brewFilterCoffee() throws CoffeeException;

}
