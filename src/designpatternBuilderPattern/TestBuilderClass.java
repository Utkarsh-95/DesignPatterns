/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package designpatternBuilderPattern;

/**
 *
 * @author Utkarsh Pratap Singh
 */
public class TestBuilderClass {

    public static void main(String[] args) {
        Computer comp = new Computer.ComputerBuilder("1000GB", "16GB", "Core i7")
                .setIsBluetoothEnabled(true)
                .setIsGraphicsCardEnabled(true)
                .build();
        System.out.println(comp.toString());
        
        Computer c = new Computer.ComputerBuilder("500GB", "8GB", "Core i5").build();
        System.out.println(c.toString());
        
    }
}
