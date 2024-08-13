package br.com.api.biju.gestao_loja.modules.people.client.dto;

import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClientCreateDTO {
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

    public ClientEntity toClientEntity(){
        ClientEntity clientEntity = new ClientEntity();
        clientEntity.setName(this.name);
        clientEntity.setCpf(this.cpf);
        clientEntity.setData_nasc(this.data_nasc);
        clientEntity.setCep(this.cep);
        clientEntity.setRua(this.rua);
        clientEntity.setNum_casa(this.num_casa);
        clientEntity.setBairro(this.bairro);
        clientEntity.setCidade(this.cidade);
        clientEntity.setEstado(this.estado);
        return clientEntity;
    }
}
