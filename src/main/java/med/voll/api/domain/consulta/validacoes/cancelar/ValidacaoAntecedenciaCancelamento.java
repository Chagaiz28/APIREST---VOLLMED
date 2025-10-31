package med.voll.api.domain.consulta.validacoes.cancelar;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.ConsultaRepository;
import med.voll.api.domain.consulta.DadosCancelamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ValidacaoAntecedenciaCancelamento implements ValidadorCancelamentoConsulta{
    @Autowired
    ConsultaRepository consultaRepository;

    @Override
    public void validar(DadosCancelamentoConsulta dados){
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        LocalDateTime dataDaConsulta = consulta.getData();
        if(dataDaConsulta.isBefore(LocalDateTime.now().plusHours(24))){
            throw new ValidacaoException("Consulta só pode ser cancelada com mais de 24h de antecedência");
        }
    }
}
