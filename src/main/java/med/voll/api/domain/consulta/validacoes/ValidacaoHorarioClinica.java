package med.voll.api.domain.consulta.validacoes;

import med.voll.api.domain.ValidacaoException;
import med.voll.api.domain.consulta.DadosAgendamentoConsulta;

import java.time.DayOfWeek;

public class ValidacaoHorarioClinica {

    public void validar(DadosAgendamentoConsulta dados){
        var data = dados.data();
        var domingo = data.getDayOfWeek().equals(DayOfWeek.SUNDAY);
        var antesDaAbertura = data.getHour() < 7;
        var depoisDoEncerramento = data.getHour() > 18;
        if(domingo || antesDaAbertura || depoisDoEncerramento){
            throw new ValidacaoException("Consulta fora do horario de funcionament da clinica");
        }
    }
}
