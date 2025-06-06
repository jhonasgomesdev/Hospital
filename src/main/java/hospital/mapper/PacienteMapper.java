package hospital.mapper;

import hospital.dtos.CriarPacienteDto;
import hospital.dtos.PacienteDto;
import hospital.model.Paciente;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface PacienteMapper {

    PacienteDto toDto(Paciente paciente);
    Paciente toEntity(PacienteDto pacienteDto);
    CriarPacienteDto toDtoCriarPaciente(Paciente paciente);
    Paciente toEntityCriarPaciente(CriarPacienteDto criarPacienteDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updatePacienteFromDto(PacienteDto pacienteDto, @MappingTarget Paciente paciente);
}
