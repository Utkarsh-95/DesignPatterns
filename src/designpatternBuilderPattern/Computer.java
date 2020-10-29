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
public class Computer {

    //required parameters
    private String HDD;
    private String RAM;
    private String PROCESSOR;

    //optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.PROCESSOR = builder.PROCESSOR;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    @Override
    public String toString() {
        return "Computer{" + "HDD=" + HDD + ", RAM=" + RAM + ", PROCESSOR=" + PROCESSOR + ", isGraphicsCardEnabled=" + isGraphicsCardEnabled + ", isBluetoothEnabled=" + isBluetoothEnabled + '}';
    }

    public static class ComputerBuilder {

        //required parameters
        private String HDD;
        private String RAM;
        private String PROCESSOR;

        //optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String hdd, String ram, String processor) {
            this.HDD = hdd;
            this.RAM = ram;
            this.PROCESSOR = processor;
        }

        public ComputerBuilder setIsGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setIsBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }

    }

}
