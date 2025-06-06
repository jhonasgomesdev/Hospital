package hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String crm;

    private String especialidade;
    private String telefone;
    private String email;

    @Column(unique = true, nullable = false)
    private String cpf;

    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private SexoMedico sexo;

    @Enumerated(EnumType.STRING)
    private StatusMedico status = StatusMedico.ATIVO;

    public Medico(){ }

    public Medico(String nome,
                  String crm,
                  String especialidade,
                  String telefone,
                  String email,
                  String cpf,
                  LocalDate dataNascimento,
                  SexoMedico sexo) {
        this.nome = nome;
        this.crm = crm;
        this.especialidade = especialidade;
        this.telefone = telefone;
        this.email = email;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
    }

    public enum StatusMedico {
        ATIVO,
        INATIVO,
        AFASTADO
    }

    public enum SexoMedico {
        MASCULINO,
        FEMININO
    }

}
