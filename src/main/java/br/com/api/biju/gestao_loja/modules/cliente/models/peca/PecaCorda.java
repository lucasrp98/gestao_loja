package br.com.api.biju.gestao_loja.modules.cliente.models.peca;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "peca_corda")
public class PecaCorda extends Peca{

    @NotBlank(message = "O comprimento é obrigatório")
    private double comprimento;

    @NotBlank(message = "O tipo de corda é obrigatória")
    private String tipo_corda;

}
