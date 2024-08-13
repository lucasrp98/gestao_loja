package br.com.api.biju.gestao_loja.modules.people.seller.dto;

import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerCreateDTO {
    private String name;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private Date data_nasc;
    private String cep;
    private String rua;
    private Integer num_casa;
    private String bairro;
    private String cidade;
    private String estado;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public SellerEntity toSellerEntity(){
        SellerEntity sellerEntity = new SellerEntity();
        sellerEntity.setName(this.name);
        sellerEntity.setCpf(this.cpf);
        sellerEntity.setData_nasc(this.data_nasc);
        sellerEntity.setCep(this.cep);
        sellerEntity.setRua(this.rua);
        sellerEntity.setNum_casa(this.num_casa);
        sellerEntity.setBairro(this.bairro);
        sellerEntity.setCidade(this.cidade);
        sellerEntity.setEstado(this.estado);
        return sellerEntity;
    }
}
