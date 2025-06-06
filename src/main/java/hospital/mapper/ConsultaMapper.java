package hospital.mapper;

import hospital.dtos.ConsultaDto;
import hospital.dtos.CriarConsultaDto;
import hospital.model.Consulta;
import hospital.util.EntityConverter;
import org.mapstruct.*;

@Mapper(componentModel = "spring", uses = EntityConverter.class)
public interface ConsultaMapper {

    @Mapping(target = "medico", source = "idMedico", qualifiedByName = "medicoFromId")
    @Mapping(target = "paciente", source = "idPaciente", qualifiedByName = "pacienteFromId")
    Consulta toEntityCriarConsulta(CriarConsultaDto criarConsultaDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateConsultaFromDto(ConsultaDto consultaDto, @MappingTarget Consulta consulta);

    @Mapping(target = "medicoId", source = "medico.id")
    @Mapping(target = "pacienteId", source = "paciente.id")
    ConsultaDto toDto(Consulta consulta);
}
