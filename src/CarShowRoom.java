
import java.util.Scanner;
// import Car_Dealer.CarDetails;

public class CarShowRoom {
    public static void main(String[]a){
        Scanner input = new Scanner(System.in);
        int cost = 0;
        // boolean verifier = true;
        int totalcost = 0;


        String CarModel;
        // Looping until we get the correct Car Model as Input.

        // while(verifier){
            System.out.print("Select car model: ");
            CarModel = input.nextLine();
            System.out.println();

            // This is an enhanced version of the switch-case provided by my IDE.

            switch (CarModel) {
                case "Polo Trendline" -> {
                    cost = 8_70_000;
                   
                    
                    break;
                }
                case "Polo Highline" -> {
                    cost = 10_09_000;
                   
                    
                    break;
                }
                case "Virtus Trendline" -> {
                    cost = 11_05_000;
                   
                    
                    break;
                }
                case "Virtus Highline" -> {
                    cost = 13_08_000;
                   
                    
                    break;
                }
                case "Taigun Trendline" -> {
                    cost = 14_89_000;
                   
                    
                    break;
                }
                case "Taigun Highline" -> {
                    cost = 15_42_000;
                   
                    
                    break;
                }
                case "Taigun Topline" -> {
                    cost = 17_71_000;
                   
                    
                    break;
                }
                default ->{
                     System.err.println("Invalid Car Model\n--- Please, TryAgain!!! ---");
                    System.exit(0);
                }
            }
        // }

        /*
        * Write the code to access the CarDetails.java file's properties,
        * Which assigns the cost of the above selected car to the Total_cost
        * */
        CarDetails carDetails = new CarDetails(cost);
        carDetails.totalcost();





        System.out.print("Do you need insurance: ");
        String question1 = input.next();
        System.out.println();
        /*
        *  Write the code to access the CarDetails.java file's properties,
        *  which assigns the car insurance cost to the Total_cost.
        */
        boolean insur = (question1.equalsIgnoreCase("Yes"));
        if(insur)
            carDetails.addins();





        System.out.print("Do you need Additional Accessories: ");
        String question2 = input.next();
        System.out.println();
        /*
        * Write the code to access the CarDetails.java file's properties,
        * Which assigns Additional Accessories cost to the Total_cost.
        * */
        boolean AddAcc = (question2.equalsIgnoreCase("Yes"));
        if( AddAcc )
            carDetails.addadacc();
        



        String discount;
        System.out.print("Dealer discount: ");
        if (AddAcc || insur){
            discount = input.next();
        }
        else{
            discount = "";
            System.out.println("0");
        }
        int Numeric = 0;
        int discountNumeric;
        /*
        * Write the code to access the CarDetails.java file's properties,
        * Which gives discount.
        * */
        if (AddAcc || insur){
            if (discount.endsWith("%")){
                // Stripping the string discount for the % removal.
                String numericPart = discount.substring(0, discount.length() - 1);
                // Type Conversion: string into an integer for further processing.
                discountNumeric = Integer.parseInt(numericPart);
                System.out.println("DiscountNumeric : "+discountNumeric);
                double discountPercentage = discountNumeric *cost;
                Numeric = (int) (discountPercentage / 100);
                System.out.println("Numeric :"+ Numeric);
                // Checking if the discount is greater than 30,000.
                if (Numeric >= 30_000){
                    System.err.println("maximum discount to be applied should not cross 30,000 and only applying 30,000 as discount.");
                    // Applying the discount as 30000.
                    carDetails.discount(30_000);
                    Numeric = 30_000;
                }
                else{
                    // Applying the discount as entered by the Dealer in Percentage.
                    discountNumeric = Integer.parseInt(numericPart);
                    Numeric = (discountNumeric / 100)*cost;
                    carDetails.discount(Numeric);
                }
            }
            else{
                // Applying the discount as entered by the Dealer in Money.
                // Type Conversion: string into an integer for further processing.
                int amount = Integer.parseInt(discount);
                Numeric = (amount / 100)*cost;
                if ( amount <= 30_000){
                    carDetails.discount(amount);
                    Numeric = amount;
                }
                else{
                    System.err.println("maximum discount to be applied should not cross 30,000"
                            + "and only applying 30,000 as discount.");
                    // Applying the discount as 30000.
                    carDetails.discount(30_000);
                    Numeric = 30_000;
                }
            }
        }





        // Calling the TCS charges, RTO.
        carDetails.addrto();
        carDetails.addtcs();





        /*
        * Write the code such that we get the Total_cost variable into this CarShowRoom.java from CarDetails.java.
        * */
        totalcost =carDetails.totalcost();
        input.close();
        



        /*
        * Total cost 19,38,290 (Taigun Topline 17,71,000 + 1,13,990(RTO) + 47,300(Insurance) +
        * 11,000(TCS) + 15,000(Additional Accessories) - 20,000(Dealer discount))
        * */
        if( insur && AddAcc){
            System.out.println("Total cost "+totalcost+" ("+CarModel+" "+ cost +" + 1,13,990(RTO) + 47,300(Insurance) + 11,000(TCS) + 15,000(Additional Accessories) - "+" "+Numeric+" (Dealer discount))");
        }
        else if ( insur && ( ! AddAcc )){
            System.out.println("Total cost "+totalcost+" ("+CarModel+" "+ cost +"  + 1,13,990(RTO) + 47,300(Insurance) + 11,000(TCS) + 0(Additional Accessories) - "+" "+Numeric+" (Dealer discount))");
        }
        else if (( ! insur ) && AddAcc){
            System.out.println("Total cost "+totalcost+" ("+CarModel+" "+ cost +" + 1,13,990(RTO) + 0(Insurance) + 11,000(TCS) + 15,000(Additional Accessories) - "+" "+Numeric+" (Dealer discount))");
        }
        else{
            System.out.println("Total cost "+totalcost+" ("+CarModel+" "+ cost +" + 1,13,990(RTO) + 0(Insurance) + 11,000(TCS) + 0(Additional Accessories) - 0(Dealer discount))");
        }
    }
}