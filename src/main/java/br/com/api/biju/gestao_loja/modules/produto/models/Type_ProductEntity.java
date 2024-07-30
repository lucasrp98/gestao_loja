package br.com.api.biju.gestao_loja.modules.produto.models;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "tipo_produto")
public class Type_ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "type_product_seq")
    @SequenceGenerator(name = "type_product_seq", sequenceName = "type_product_seq", allocationSize = 1)
    private int id;
    @NotBlank(message = "O nome do tipo de produto é obrigatório")
    @Size(max = 100, message = "O nome do tipo de produto deve ter no máximo 100 caracteres")
    private String nome;
    @OneToMany(mappedBy = "tipo_produto")
    @JsonManagedReference
    private List<ProductEntity> produtos = new ArrayList<>();
}
