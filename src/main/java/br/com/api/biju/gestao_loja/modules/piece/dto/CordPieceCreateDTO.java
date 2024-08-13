package br.com.api.biju.gestao_loja.modules.piece.dto;

import br.com.api.biju.gestao_loja.modules.piece.models.CordPieceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class CordPieceCreateDTO {
    private String nome;
    private int estoque;
    private double custo;
    private double comprimento;
    private String tipo_corda;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public CordPieceEntity toCordPieceEntity(){
        CordPieceEntity cordPieceEntity = new CordPieceEntity();
        cordPieceEntity.setNome(this.nome);
        cordPieceEntity.setEstoque(this.estoque);
        cordPieceEntity.setCusto(this.custo);
        cordPieceEntity.setComprimento(this.comprimento);
        cordPieceEntity.setTipo_corda(this.tipo_corda);
        return cordPieceEntity;
    }
}
