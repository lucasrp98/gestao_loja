package br.com.api.biju.gestao_loja.modules.cliente.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name = "cliente")
public class ClienteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int id;
    @NotBlank(message = "O nome é obrigatório")
    @Size(max = 100, message = "O nome deve ter no máximo 100 caracteres")
    private String name;
    @NotBlank(message = "O CPF é obrigatório")
    @Pattern(regexp = "\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}", message = "O CPF deve estar no formato 999.999.999-99")
    private String cpf;
    @JsonFormat(pattern = "dd/MM/yyyy")
    @Past(message = "A data de nascimento deve estar no passado")
    private Date data_nasc;
    @NotNull(message = "O CEP é obrigatório")
    @Pattern(regexp = "\\d{5}-\\d{3}", message = "O CEP deve conter apenas números e estar no formato 999999-999")
    private String cep;
    private String rua;
    private Integer num_casa;
    private String bairro;
    private String cidade;
    private String estado;
    @CreationTimestamp
    private LocalDateTime createdAt;
}

