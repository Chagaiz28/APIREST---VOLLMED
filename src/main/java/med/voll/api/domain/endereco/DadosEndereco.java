package med.voll.api.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Embeddable
public record DadosEndereco(
        @NotBlank
        String logradouro,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String uf,
        String bairro,
        String complemento,
        String numero,
        @NotBlank
        String cidade) {
}
