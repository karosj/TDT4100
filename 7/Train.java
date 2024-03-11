import java.util.ArrayList;
import java.util.Collection;

public class Train {
    private Collection <TrainCar> trainCars;

    public Train() {
        trainCars = new ArrayList<TrainCar>();
    }

    public boolean contains(TrainCar trainCar) {
        return trainCars.contains(trainCar);
    }

    public void addTrainCar(TrainCar trainCar) {
        trainCars.add(trainCar);
    }

    public int getTotalWeight() {
        int totalWeight = 0;
        for (TrainCar trainCar : trainCars) {
            totalWeight += trainCar.getTotalWeight();
        }
        return totalWeight;
    }

    public int getPassengerCount() {
        int passengerCount = 0;
        for (TrainCar trainCar : trainCars) {
            if (trainCar instanceof PassengerCar) {
                passengerCount += ((PassengerCar) trainCar).getPassengerCount();
            }
        }
        return passengerCount;
    }

    public int getCargoWeight() {
        int cargoWeight = 0;
        for (TrainCar trainCar : trainCars) {
            if (trainCar instanceof CargoCar) {
                cargoWeight += ((CargoCar) trainCar).getCargoWeight();
            }
        }
        return cargoWeight;
    }

    @Override
    public String toString() {
        String output = "";
        for (TrainCar trainCar : trainCars) {
            output += trainCar.toString() + "\n";
        }
        return output;
    }

}
