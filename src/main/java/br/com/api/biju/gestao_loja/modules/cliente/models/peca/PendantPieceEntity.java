package br.com.api.biju.gestao_loja.modules.cliente.models.peca;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity(name = "peca_pingente")
public class PendantPieceEntity extends PieceEntity {

    @NotBlank(message = "O tipo de metal é obrigatório")
    private String metal;
    @NotBlank(message = "O formato do pingente é obrigatório")
    private String formato;
    @NotBlank(message = "A cor do pingente é obrigatória")
    private String cor;
}
