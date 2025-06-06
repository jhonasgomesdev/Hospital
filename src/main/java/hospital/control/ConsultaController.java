package hospital.control;

import hospital.dtos.ConsultaDto;
import hospital.dtos.CriarConsultaDto;
import hospital.mapper.ConsultaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import hospital.repository.ConsultaRepository;
import hospital.model.Consulta;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/consulta")
public class ConsultaController {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private ConsultaMapper consultaMapper;

    @GetMapping
    public List<ConsultaDto> GetAllConsultas(){
        return consultaRepository.findAll()
                .stream()
                .map(consultaMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ConsultaDto GetConsultaById(@PathVariable Integer id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        return consultaMapper.toDto(consulta);
    }

    @PostMapping
    public ConsultaDto Post(@RequestBody CriarConsultaDto criarConsultaDto){
        Consulta consulta = consultaMapper.toEntityCriarConsulta(criarConsultaDto);
        consultaRepository.save(consulta);
        return consultaMapper.toDto(consulta);
    }

    @PutMapping("/{id}")
    public ConsultaDto Put(@PathVariable Integer id, @RequestBody ConsultaDto novaConsulta){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consultaMapper.updateConsultaFromDto(novaConsulta,consulta);
        consultaRepository.save(consulta);

        return consultaMapper.toDto(consulta);
    }

    @DeleteMapping("/{id}")
    public ConsultaDto Delete(@PathVariable Integer id){
        Consulta consulta = consultaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Consulta não encontrada!"));
        consultaRepository.delete(consulta);
        return consultaMapper.toDto(consulta);
    }
}
