package br.com.api.biju.gestao_loja.modules.cliente;

import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AllArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

public class ClienteEntity {
    private UUID id;
    @Getter
    private String name;
    @Getter
    private String cpf;
    @Getter
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date data_nasc;
    private Integer cep;
    private String rua;
    private Integer num_casa;
    private String bairro;
    private String cidade;
    private String estado;
}

