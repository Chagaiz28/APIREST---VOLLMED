package med.voll.api.domain.consulta.validacoes.cancelar;

import med.voll.api.domain.consulta.DadosCancelamentoConsulta;

public interface ValidadorCancelamentoConsulta {

    void validar(DadosCancelamentoConsulta dados);
}
