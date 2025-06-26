package hospital.control;

import hospital.dtos.ConsultaDto;
import hospital.dtos.CriarConsultaDto;
import hospital.mapper.ConsultaMapper;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import hospital.repository.ConsultaRepository;
import hospital.model.Consulta;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta")
@Tag(name = "Consulta", description = "CRUD de Consultas")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;

    @Autowired
    private ConsultaMapper consultaMapper;

    @Operation(summary = "Listar todas as consultas")
    @ApiResponse(responseCode = "200", description = "Lista de consultas retornada com sucesso")
    @GetMapping
    public List<ConsultaDto> GetAllConsultas() {
        return consultaRepository.findAll()
                .stream()
                .map(consultaMapper::toDto)
                .collect(Collectors.toList());
    }

    @Operation(summary = "Buscar consulta por ID")
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Consulta encontrada"),
            @ApiResponse(responseCode = "404", description = "Consulta não encontrada")
    })
    @GetMapping("/{id}")
    public ConsultaDto GetConsultaById(@PathVariable Integer id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        return consultaMapper.toDto(consulta);
    }

    @Operation(summary = "Criar nova consulta")
    @ApiResponse(responseCode = "201", description = "Consulta criada com sucesso")
    @PostMapping
    public ConsultaDto Post(@RequestBody CriarConsultaDto criarConsultaDto) {
        Consulta consulta = consultaMapper.toEntityCriarConsulta(criarConsultaDto);
        consultaRepository.save(consulta);
        return consultaMapper.toDto(consulta);
    }

    @Operation(summary = "Atualizar consulta existente")
    @ApiResponse(responseCode = "200", description = "Consulta atualizada com sucesso")
    @PutMapping("/{id}")
    public ConsultaDto Put(@PathVariable Integer id, @RequestBody ConsultaDto novaConsulta) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consultaMapper.updateConsultaFromDto(novaConsulta, consulta);
        consultaRepository.save(consulta);
        return consultaMapper.toDto(consulta);
    }

    @Operation(summary = "Deletar consulta")
    @ApiResponse(responseCode = "200", description = "Consulta deletada com sucesso")
    @DeleteMapping("/{id}")
    public ConsultaDto Delete(@PathVariable Integer id) {
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consultaRepository.delete(consulta);
        return consultaMapper.toDto(consulta);
    }
}
