package hospital.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private LocalDateTime dataHora;

    @Enumerated(EnumType.STRING)
    private StatusConsulta status = StatusConsulta.AGENDADA;

    private String observacoes;

    @ManyToOne
    @JoinColumn(name ="medico_id",nullable = false)
    private Medico medico;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    private String motivo;

    public Consulta(){ }

    public Consulta(LocalDateTime dataHora,
                    String observacoes,
                    Medico medico,
                    Paciente paciente,
                    String motivo) {
        this.dataHora = dataHora;
        this.observacoes = observacoes;
        this.medico = medico;
        this.paciente = paciente;
        this.motivo = motivo;
    }

    public enum StatusConsulta {
        AGENDADA,
        REALIZADA,
        CANCELADA
    }
}
