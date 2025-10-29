package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;
import med.voll.api.domain.paciente.PacienteRepository;

public class ValidacaoPacienteInativo {
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var paciente = repository.getReferenceById(dados.idPaciente());
        var ativo = paciente.getAtivo();
        if(!ativo){
            throw new ValidacaoException("Paciente inativo");
        }
    }
}
