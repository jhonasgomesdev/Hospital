package hospital.control;

import hospital.dtos.CriarPacienteDto;
import hospital.dtos.PacienteDto;
import hospital.mapper.PacienteMapper;
import hospital.repository.PacienteRepository;
import hospital.model.Paciente;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/paciente")
@Tag(name = "Paciente", description = "CRUD de Pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Autowired
    private PacienteMapper pacienteMapper;

    @Operation(summary = "Listar todos os pacientes")
    @GetMapping
    public List<PacienteDto> GetAllPacientes() {
        return pacienteRepository.findAll()
                .stream()
                .map(pacienteMapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Buscar paciente por ID")
    @GetMapping("/{id}")
    public PacienteDto GetById(@PathVariable Integer id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
        return pacienteMapper.toDto(paciente);
    }

    @Operation(summary = "Criar novo paciente")
    @PostMapping
    public PacienteDto Post(@RequestBody CriarPacienteDto criarPacienteDto) {
        Paciente paciente = pacienteMapper.toEntityCriarPaciente(criarPacienteDto);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDto(paciente);
    }

    @Operation(summary = "Atualizar paciente")
    @PutMapping("/{id}")
    public PacienteDto Put(@PathVariable Integer id, @RequestBody PacienteDto novoPacienteDto) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
        pacienteMapper.updatePacienteFromDto(novoPacienteDto, paciente);
        pacienteRepository.save(paciente);
        return pacienteMapper.toDto(paciente);
    }

    @Operation(summary = "Deletar paciente")
    @DeleteMapping("/{id}")
    public PacienteDto Delete(@PathVariable Integer id) {
        Paciente paciente = pacienteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Paciente não encontrado!"));
        pacienteRepository.delete(paciente);
        return pacienteMapper.toDto(paciente);
    }
}
