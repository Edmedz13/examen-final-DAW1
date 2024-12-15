package pe.edu.cibertec.examan_final_daw1.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.edu.cibertec.examan_final_daw1.dto.CarDetailDto;
import pe.edu.cibertec.examan_final_daw1.dto.CarDto;
import pe.edu.cibertec.examan_final_daw1.entity.Car;
import pe.edu.cibertec.examan_final_daw1.repository.CarRepository;
import pe.edu.cibertec.examan_final_daw1.service.ManageService;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    CarRepository carRepository;

    @Override
    public List<CarDto> getAllCars() throws Exception {

        List<CarDto> cars = new ArrayList<CarDto>();
        Iterable<Car> iterable = carRepository.findAll();
        iterable.forEach(car -> {
            cars.add(new CarDto(car.getCar_id(), car.getMake(), car.getModel(), car.getYear(), car.getOwner_name()));
        });
        return cars;

    }

    @Override
    public Optional<CarDetailDto> getCarById(int id) throws Exception {


        Optional<Car> optional = carRepository.findById(id);
        return optional.map(car -> new CarDetailDto(car.getCar_id(),
                car.getMake(),
                car.getModel(),
                car.getYear(),
                car.getVin(),
                car.getLicense_plate(),
                car.getOwner_name(),
                car.getOwner_contact(),
                car.getPurchase_date(),
                car.getMileage(),
                car.getEngine_type(),
                car.getColor(),
                car.getInsurance_company(),
                car.getInsurance_policy_number(),
                car.getRegistration_expiration_date(),
                car.getService_due_date()));

    }

    @Override
    public boolean updateCar(CarDetailDto carDetailDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDto.car_id());
        return optional.map( car -> {
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicense_plate(carDetailDto.license_plate());
            car.setOwner_name(carDetailDto.owner_name());
            car.setOwner_contact(carDetailDto.owner_contact());
            car.setPurchase_date(carDetailDto.purchase_date());
            car.setMileage(carDetailDto.mileage());
            car.setEngine_type(carDetailDto.engine_type());
            car.setColor(carDetailDto.color());
            car.setInsurance_company(carDetailDto.insurance_company());
            car.setInsurance_policy_number(carDetailDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
            car.setService_due_date(carDetailDto.service_due_date());
            carRepository.save(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteCarById(int id) throws Exception {

        Optional<Car> optional = carRepository.findById(id);
        return optional.map( car -> {
            carRepository.delete(car);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addCar(CarDetailDto carDetailDto) throws Exception {

        Optional<Car> optional = carRepository.findById(carDetailDto.car_id());
        if (optional.isEmpty()){
            Car car = new Car();
            car.setMake(carDetailDto.make());
            car.setModel(carDetailDto.model());
            car.setYear(carDetailDto.year());
            car.setVin(carDetailDto.vin());
            car.setLicense_plate(carDetailDto.license_plate());
            car.setOwner_name(carDetailDto.owner_name());
            car.setOwner_contact(carDetailDto.owner_contact());
            car.setPurchase_date(carDetailDto.purchase_date());
            car.setMileage(carDetailDto.mileage());
            car.setEngine_type(carDetailDto.engine_type());
            car.setColor(carDetailDto.color());
            car.setInsurance_company(carDetailDto.insurance_company());
            car.setInsurance_policy_number(carDetailDto.insurance_policy_number());
            car.setRegistration_expiration_date(carDetailDto.registration_expiration_date());
            car.setService_due_date(carDetailDto.service_due_date());
            carRepository.save(car);
            return true;

        }
         return false;
    }
}
