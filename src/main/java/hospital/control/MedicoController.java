package hospital.control;

import hospital.dtos.CriarMedicoDto;
import hospital.dtos.MedicoDto;
import hospital.mapper.MedicoMapper;
import hospital.repository.MedicoRepository;
import hospital.model.Medico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/medico")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    @GetMapping
    public List<MedicoDto> GetAllMedicos(){
        return medicoRepository.findAll()
                .stream()
                .map(medicoMapper::toDto)
                .collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public MedicoDto GetMedicoById(@PathVariable Integer id){
        Medico medico = medicoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        return medicoMapper.toDto(medico);
    }

    @PostMapping
    public MedicoDto Post(@RequestBody CriarMedicoDto criarMedicoDto){
        Medico medico = medicoMapper.toEntityCriarMedico(criarMedicoDto);
        medicoRepository.save(medico);
        return medicoMapper.toDto(medico);
    }

    @PutMapping("/{id}")
    public MedicoDto Put(@PathVariable Integer id, @RequestBody MedicoDto novoMedicoDto){
        Medico medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medicoMapper.updateMedicoFromDto(novoMedicoDto, medico);
        medicoRepository.save(medico);

        return medicoMapper.toDto(medico);
    }

    @DeleteMapping("/{id}")
    public MedicoDto Delete(@PathVariable Integer id){
        Medico medico = medicoRepository.findById(id).orElseThrow(() -> new RuntimeException("Médico não encontrado!"));
        medicoRepository.delete(medico);

        return medicoMapper.toDto(medico);
    }
}
