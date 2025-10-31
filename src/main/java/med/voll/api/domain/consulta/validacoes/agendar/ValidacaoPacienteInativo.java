package med.voll.api.domain.consulta.validacoes.agendar;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidacaoPacienteInativo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var paciente = repository.getReferenceById(dados.idPaciente());
        var ativo = paciente.getAtivo();
        if(!ativo){
            throw new ValidacaoException("Paciente inativo");
        }
    }
}
