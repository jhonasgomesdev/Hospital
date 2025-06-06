package hospital.mapper;

import hospital.dtos.CriarMedicoDto;
import hospital.dtos.MedicoDto;
import hospital.model.Medico;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

@Mapper(componentModel = "spring")
public interface MedicoMapper {

    MedicoDto toDto(Medico medico);
    Medico toEntity(MedicoDto medicoDto);
    CriarMedicoDto toDtoCriarMedico(Medico medico);
    Medico toEntityCriarMedico(CriarMedicoDto medicoDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void updateMedicoFromDto(MedicoDto medicoDto, @MappingTarget Medico medico);
}
