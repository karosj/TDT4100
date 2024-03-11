public class PassengerCar extends TrainCar{
    private static final int PASSENGER_WEIGHT = 80;
    private int passengerCount;

    public PassengerCar(int deadWeight, int passengerCount) {
        super(deadWeight);
        this.passengerCount = passengerCount;
    }

    public int getPassengerCount() {
        return passengerCount;
    }

    public void setPassengerCount(int passengerCount) {
        this.passengerCount = passengerCount;
    }

    public int getTotalWeight() {
        return super.getDeadWeight() + passengerCount * PASSENGER_WEIGHT;
    }
}
