package hospital.util;

import ch.qos.logback.core.net.SyslogOutputStream;
import hospital.model.Medico;
import hospital.model.Paciente;
import hospital.repository.MedicoRepository;
import hospital.repository.PacienteRepository;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EntityConverter {

    private final MedicoRepository medicoRepository;
    private final PacienteRepository pacienteRepository;

    @Autowired
    public  EntityConverter(MedicoRepository medicoRepository, PacienteRepository pacienteRepository){
        this.medicoRepository = medicoRepository;
        this.pacienteRepository = pacienteRepository;
    }

    @Named("medicoFromId")
    public Medico medicoFromId(Integer id){
        return medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado com ID: " + id));
    }

    @Named("pacienteFromId")
    public Paciente pacienteFromId(Integer id){
        return pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado com ID:" + id));
    }
}
