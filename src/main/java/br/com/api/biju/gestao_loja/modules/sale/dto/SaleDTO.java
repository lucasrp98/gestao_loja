package br.com.api.biju.gestao_loja.modules.sale.dto;

import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import br.com.api.biju.gestao_loja.modules.piece.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SaleDTO {
    private Date data_venda;
    private double valor_venda;
    private int quantidade;
    private double valor_frete;
    private Integer clientID;
    private Integer paymentMethodID;
    private Integer sellerID;
    private List<Integer> list_products;
    @CreationTimestamp
    private LocalDateTime createdAt;

    public SaleEntity toSaleEntity(ClientEntity clientEntity, Payment_MethodEntity paymentMethodEntity, SellerEntity sellerEntity, List<ProductEntity> products) {
        SaleEntity saleEntity = new SaleEntity();
        saleEntity.setData_venda(this.data_venda);
        saleEntity.setValor_venda(this.valor_venda);
        saleEntity.setQuantidade(this.quantidade);
        saleEntity.setValor_frete(this.valor_frete);
        saleEntity.setClientEntity(clientEntity);
        saleEntity.setPaymentMethodEntity(paymentMethodEntity);
        saleEntity.setSellerEntity(sellerEntity);
        saleEntity.setProductEntityList(products);
        return saleEntity;
    }

}
