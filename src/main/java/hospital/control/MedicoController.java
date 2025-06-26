package hospital.control;

import hospital.dtos.CriarMedicoDto;
import hospital.dtos.MedicoDto;
import hospital.mapper.MedicoMapper;
import hospital.repository.MedicoRepository;
import hospital.model.Medico;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medico")
@Tag(name = "Médico", description = "CRUD de Médicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @Autowired
    private MedicoMapper medicoMapper;

    @Operation(summary = "Listar todos os médicos")
    @GetMapping
    public List<MedicoDto> GetAllMedicos() {
        return medicoRepository.findAll()
                .stream()
                .map(medicoMapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Buscar médico por ID")
    @GetMapping("/{id}")
    public MedicoDto GetMedicoById(@PathVariable Integer id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        return medicoMapper.toDto(medico);
    }

    @Operation(summary = "Criar novo médico")
    @PostMapping
    public MedicoDto Post(@RequestBody CriarMedicoDto criarMedicoDto) {
        Medico medico = medicoMapper.toEntityCriarMedico(criarMedicoDto);
        medicoRepository.save(medico);
        return medicoMapper.toDto(medico);
    }

    @Operation(summary = "Atualizar médico")
    @PutMapping("/{id}")
    public MedicoDto Put(@PathVariable Integer id, @RequestBody MedicoDto novoMedicoDto) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medicoMapper.updateMedicoFromDto(novoMedicoDto, medico);
        medicoRepository.save(medico);
        return medicoMapper.toDto(medico);
    }

    @Operation(summary = "Deletar médico")
    @DeleteMapping("/{id}")
    public MedicoDto Delete(@PathVariable Integer id) {
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medicoRepository.delete(medico);
        return medicoMapper.toDto(medico);
    }
}
