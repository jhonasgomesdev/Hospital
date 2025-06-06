package hospital.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class MedicoDto {

    private Integer id;
    private String nome;
    private String crm;
    private String especialidade;
    private String telefone;
    private String email;
    private String cpf;
    private LocalDate dataNascimento;
    private String sexo;
    private String status;

}
