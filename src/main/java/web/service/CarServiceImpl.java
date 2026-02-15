package web.service;

import org.springframework.stereotype.Service;
import web.model.Car;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarServiceImpl implements CarService{
    private List<Car> cars;

    {
        cars = new ArrayList<>();
        cars.add(new Car("Mercedes", 120, "blue"));
        cars.add(new Car("Porsche", 140, "white"));
        cars.add(new Car("Jaguar", 160, "black"));
        cars.add(new Car("Dodge", 180, "orange"));
        cars.add(new Car("Lamborghini", 200, "green"));
    }

    @Override
    public List<Car> getCarList() {
        return cars;
    }

    @Override
    public List<Car> getCarSublist(List<Car> cars, int count) {
       if (cars.size() > count && count >= 0) {
           return cars.subList(0, count);
       } else {
           return cars;
       }
    }
}
