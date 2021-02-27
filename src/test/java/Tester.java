import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Map;

import static org.junit.Assert.assertSame;

class Tester {
    private GarageImpl garage;
    private ArrayList<Car> cars;
    private Map<Integer, Owner> owners;

    @Before
    public void setUp() {
        garage = new GarageImpl();

        Car car1 = new Car(1, "a", "1", 320, 100, 1);
        Car car2 = new Car(2, "a", "1", 320, 100, 1);
        Car car3 = new Car(3, "a", "1", 320, 100, 1);
        Owner owner1 = new Owner("A", "S", 21, 1);

        cars.add(car1);
        cars.add(car2);
        cars.add(car3);
        owners.put(owner1.getId(), owner1);
    }

    @Before
    public void addNewCar() {
        for(var car: cars) {
            var owner = owners.get(car.getOwnerId());
            garage.addNewCar(car, owner);
        }
    }

    @Test
    public void allCarsUniqueOwners() {
        assertSame(garage.allCarsUniqueOwners(), owners);
    }

    @Test
    public void topThreeCarsByMaxVelocity() {
        assertSame(garage.topThreeCarsByMaxVelocity(), cars);
    }

    @Test
    public void allCarsOfBrand() {
        assertSame(garage.allCarsOfBrand("a"), cars);
    }

    @Test
    public void carsWithPowerMoreThan() {
        assertSame(garage.carsWithPowerMoreThan(90), cars);
    }

    @Test
    public void allCarsOfOwner() {
        assertSame(garage.allCarsOfOwner(owners.get("1")), cars);
    }

    @Test
    public void meanOwnersAgeOfCarBrand() {
        assertSame(garage.meanOwnersAgeOfCarBrand("a"), 21);
    }

    @Test
    public void meanCarNumberForEachOwner() {
        assertSame(garage.meanCarNumberForEachOwner(), 3);
    }
}