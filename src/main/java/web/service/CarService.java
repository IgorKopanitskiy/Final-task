package web.service;

import web.model.Car;

import java.util.List;

public interface CarService {
    public List<Car> getCarList();
    public List<Car> getCarSublist(List<Car> cars, int count);
}
