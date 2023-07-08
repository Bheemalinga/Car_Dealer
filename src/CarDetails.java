
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
    }
    public int addrto() {
        return Total_Cost += RTO;
    }
    public int addins() {
        return Total_Cost += Ins;
    }
    public int addtcs() {
        return Total_Cost += Tcs;
    }
    public int addadacc() {
        return Total_Cost += Ad_Acc;
    }
    public int discount(int discount) {
        return Total_Cost -= discount;
    }
    public int totalcost() {
        return Total_Cost;
    }

}