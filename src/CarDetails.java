
public class CarDetails {
    private final int RTO = 1_13_990;

    // Ins = insurance.
    private final int Ins = 47_300;

    // Tcs = TCS Charges.
    private final int Tcs = 11_000;

    // Additional Accessories = Ad_Acc.
    private final int Ad_Acc = 15_000;
    int Total_Cost;

    public CarDetails(int Total_Cost) {
        this.Total_Cost = Total_Cost;
        System.out.print(Total_Cost);
    }
    public int addrto() {
        System.out.println(Total_Cost + RTO);
        return Total_Cost += RTO;
    }
    public int addins() {
        System.out.println(Total_Cost + Ins);
        return Total_Cost += Ins;
    }
    public int addtcs() {
        System.out.println(Total_Cost + Tcs);
        return Total_Cost += Tcs;
    }
    public int addadacc() {
        System.out.println(Total_Cost + Ad_Acc);
        return Total_Cost += Ad_Acc;
    }
    public int discount(int discount) {
        System.out.println(Total_Cost - discount);
        return Total_Cost -= discount;
    }
    public int totalcost() {
        System.out.println(Total_Cost);
        return Total_Cost;
    }

}