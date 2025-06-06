package hospital.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nome;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String telefone;
    private String email;
    private LocalDate dataNascimento;

    @Enumerated(EnumType.STRING)
    private SexoPaciente sexo;

    private String endereco;
    private String convenio;

    public Paciente(){ }

    public Paciente(String nome,
                    String cpf,
                    String telefone,
                    String email,
                    LocalDate dataNascimento,
                    SexoPaciente sexo,
                    String endereco,
                    String convenio) {
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.convenio = convenio;
    }

    public enum SexoPaciente {
        MASCULINO,
        FEMININO
    }
}
