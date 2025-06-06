package hospital.dtos;

import hospital.model.Consulta;
import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ConsultaDto {

    private Integer id;
    private Integer medicoId;
    private Integer pacienteId;
    private LocalDateTime dataHora;
    private String motivo;
    private String observacoes;
    private Consulta.StatusConsulta status;

}
