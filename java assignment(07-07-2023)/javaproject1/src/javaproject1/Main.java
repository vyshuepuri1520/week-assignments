package javaproject1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] carname = {"Polo Trendline","Polo Highline","Virtus Trendline","Virtus Highline","Taigun Trendline","Taigun Trendline","Taigun Highline","Taigun Topline"};
        System.out.println("cars in my showrrom are : ");
        for (int i = 0;i<carname.length;i++)
        {
        	System.out.println(carname[i]+" ");
        }

        Car[] cars = {
            new Car("Polo Trendline", 870000),
            new Car("Polo Highline", 1009000),
            new Car("Virtus Trendline", 1105000),
            new Car("Virtus Highline", 1308000),
            new Car("Taigun Trendline", 1489000),
            new Car("Taigun Highline", 1542000),
            new Car("Taigun Topline", 1771000)
        };
        
        Car pcar = new Car("temp",0);

        System.out.print("Select car model: ");
        String inputCar = scanner.nextLine();
        System.out.println("Selected car model: " + inputCar);

        boolean carFound = false;
        for (Car car : cars) {
            if (car.getModel().equals(inputCar)) {
                pcar = car;
                System.out.println("You selected " + car.getModel() + " with price " + car.getCost());
                carFound = true;
                break;
            }
        }

        if (!carFound) {
            System.out.println("Car model not found!");
            return ;
        }
        
        System.out.print("Do you need Insurance: ");
        String insurance = scanner.nextLine();
        if (insurance.equals("yes")){
            pcar.insurancemethod();
        }
        else{
            insurance="no";
        }
        
        System.out.print("Do you need Additional Accessories: ");
        String addacc = scanner.nextLine();
        if (addacc.equals("yes")){
            pcar.addaccmethod();
        }
        else{
            addacc="no";
        }
        
        if(insurance.equals("yes") || addacc.equals("yes")){
        System.out.print("Dealer discount: ");
        String dis = scanner.nextLine();
        pcar.discount(dis);
        }
        else{
            System.out.print("Dealer discount:0\n");
        }
        
        pcar.gettotalcost();

    }
}
