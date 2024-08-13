package br.com.api.biju.gestao_loja.modules.piece.dto;

import br.com.api.biju.gestao_loja.modules.piece.models.PendantPieceEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PendantPieceCreateDTO {
    private String nome;
    private int estoque;
    private double custo;
    private String metal;
    private String formato;
    private String cor;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public PendantPieceEntity toPendantPieceEntity(){
        PendantPieceEntity pendantPieceEntity = new PendantPieceEntity();
        pendantPieceEntity.setNome(this.nome);
        pendantPieceEntity.setEstoque(this.estoque);
        pendantPieceEntity.setCusto(this.custo);
        pendantPieceEntity.setMetal(this.metal);
        pendantPieceEntity.setFormato(this.formato);
        pendantPieceEntity.setCor(this.cor);
        return pendantPieceEntity;
    }
}
