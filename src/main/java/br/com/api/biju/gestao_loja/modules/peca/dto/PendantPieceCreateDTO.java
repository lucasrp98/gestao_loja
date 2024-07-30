package br.com.api.biju.gestao_loja.modules.peca.dto;

import br.com.api.biju.gestao_loja.modules.peca.models.CordPieceEntity;
import br.com.api.biju.gestao_loja.modules.peca.models.PendantPieceEntity;
import jakarta.validation.constraints.NotBlank;
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
