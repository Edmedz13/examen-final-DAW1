package pe.edu.cibertec.examan_final_daw1.response;

import pe.edu.cibertec.examan_final_daw1.dto.CarDetailDto;

public record FindCarResponse(String code,
                              String error,
                              CarDetailDto car) {
}
