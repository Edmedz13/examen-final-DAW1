package pe.edu.cibertec.examan_final_daw1.response;

import pe.edu.cibertec.examan_final_daw1.dto.CarDto;

public record FindCarsResponse(String code,
                               String error,
                               Iterable<CarDto> cars) {

}
