import java.util.*;

public class GarageImpl implements Garage{
    private Map<Owner, ArrayList<Car>> ownerXCar;
    private List<Car> carList;
    private Map<Integer, Owner> ownerList;
    private Map<String, Car> brands;

    @Override
    public Collection<Owner> allCarsUniqueOwners() {
        return ownerXCar.keySet();
    }

    @Override
    public Collection<Car> topThreeCarsByMaxVelocity() {
        carList.sort(
                Comparator.comparingInt(Car::getMaxVelocity)
        );

        List<Car> ans = new ArrayList<Car>();
        ans.add(carList.get(0));
        ans.add(carList.get(1));
        ans.add(carList.get(2));

        return ans;
    }

    @Override
    public Collection<Car> allCarsOfBrand(String brand) {
        return brands.values();
    }

    @Override
    public Collection<Car> carsWithPowerMoreThan(int power) {
        ArrayList<Car> ans = new ArrayList<Car>();

        for (var car: carList){
            if (car.getPower()>power) {
               ans.add(car);
            }
        }

        return ans;
    }

    @Override
    public Collection<Car> allCarsOfOwner(Owner owner) {
        return ownerXCar.get(owner);
    }

    @Override
    public int meanOwnersAgeOfCarBrand(String brand) {
        int age = 0;
        int cars = 0;

        for(var car : carList) {
            if (car.getBrand().equals(brand)) {
                var owner = ownerList.get(car.getOwnerId());
                age += owner.getAge();
                cars += 1;
            }
        }

        if (cars == 0) {
            return 0;
        }

        return age/cars;

    }

    @Override
    public int meanCarNumberForEachOwner() {
        return carList.size()/ownerXCar.keySet().size();
    }

    @Override
    public Car removeCar(int carId) {
        Car ans = null;

        for (var car : carList) {
            if (car.getCarId() == carId) {
                ans = car;
            }
        }

        var ownerId = ans.getOwnerId();
        var owner = ownerList.get(ownerId);
        var cars = ownerXCar.get(ownerId);
        cars.remove(ans);

        ownerXCar.put(owner, cars);

        return ans;
    }

    @Override
    public void addNewCar(Car car, Owner owner) {
        ArrayList<Car> cars = ownerXCar.get(owner);
        cars.add(car);
        ownerXCar.put(owner, cars);

        brands.put(car.getBrand(), car);
        ownerList.put(owner.getId(), owner);
        carList.add(car);
    }
}
