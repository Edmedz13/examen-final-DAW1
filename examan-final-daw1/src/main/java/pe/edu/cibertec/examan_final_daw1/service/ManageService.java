package pe.edu.cibertec.examan_final_daw1.service;

import pe.edu.cibertec.examan_final_daw1.dto.CarDetailDto;
import pe.edu.cibertec.examan_final_daw1.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;

    Optional<CarDetailDto> getCarById(int id) throws Exception;

    boolean updateCar(CarDetailDto carDetailDto) throws Exception;

    boolean deleteCarById(int id) throws Exception;

    boolean addCar(CarDetailDto carDetailDto) throws Exception;

}
