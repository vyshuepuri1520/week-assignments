package javaproject1;

public class Car {
    private String model;
    private int cost;
    private int totalcost = cost;
    private int finaldiscount = 0;
    private int insurance = 0;
    private int addacc = 0;


    public Car(String model, int cost) {
        this.model = model;
        this.cost = cost;
        this.totalcost = cost+113990+11000;
    }

    public String getModel() {
        return model;
    }
    
    public int discount(String dis){
        if (dis.endsWith("%")){
             String percentageString = dis.substring(0, dis.length() - 1);
             int discountPer = Integer.parseInt(percentageString);
             finaldiscount = cost*discountPer/100;
        }
        else{
            int finaldiscount = Integer.parseInt(dis);
        }
        if (finaldiscount>30000){
                 System.out.print("Discount should not exceed 30,000 so we are giving 30,000 Discount");
                 finaldiscount = 30000;
        }
        totalcost=totalcost-finaldiscount;
        return 0;
    }
    
    public int insurancemethod(){
        totalcost = totalcost+ 47300;
        insurance = 47300;
        return 0;
    }
    
    public int addaccmethod(){
        totalcost = totalcost+ 15000;
        addacc = 15000;
        return 0;
    }

    public int getCost() {
        return cost;
    }
    
    public int gettotalcost() {
        System.out.print("Total cost "+totalcost+" ("+model+" "+cost+" + "+"1,13,990(RTO) +"+insurance+"(insurance) + 11,000(TCS) + "
        +addacc+"(Additional Accessories) -"+finaldiscount+"(Dealer discount))");
        return 0;
    }
}