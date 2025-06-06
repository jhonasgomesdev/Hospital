package hospital.dtos;

import hospital.model.Consulta;
import hospital.model.Medico;
import hospital.model.Paciente;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class CriarConsultaDto {

    private Integer idMedico;
    private Integer idPaciente;
    private LocalDateTime dataHora;
    private String observacoes;
    private String motivo;


}
