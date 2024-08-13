package br.com.api.biju.gestao_loja.modules.sale.useCases;

import br.com.api.biju.gestao_loja.modules.exceptions.*;
import br.com.api.biju.gestao_loja.modules.payment_method.models.Payment_MethodEntity;
import br.com.api.biju.gestao_loja.modules.payment_method.repositories.Payment_MethodRepository;
import br.com.api.biju.gestao_loja.modules.people.client.models.ClientEntity;
import br.com.api.biju.gestao_loja.modules.people.client.repositories.ClientRepository;
import br.com.api.biju.gestao_loja.modules.people.seller.models.SellerEntity;
import br.com.api.biju.gestao_loja.modules.people.seller.repositories.SellerRepository;
import br.com.api.biju.gestao_loja.modules.piece.models.PieceEntity;
import br.com.api.biju.gestao_loja.modules.product.dto.ProductCreationDTO;
import br.com.api.biju.gestao_loja.modules.product.models.ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.models.Type_ProductEntity;
import br.com.api.biju.gestao_loja.modules.product.repositories.ProductRepository;
import br.com.api.biju.gestao_loja.modules.sale.dto.SaleDTO;
import br.com.api.biju.gestao_loja.modules.sale.models.SaleEntity;
import br.com.api.biju.gestao_loja.modules.sale.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CreateSaleUseCase {

    @Autowired
    SaleRepository saleRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    Payment_MethodRepository paymentMethodRepository;

    @Autowired
    SellerRepository sellerRepository;

    @Autowired
    ProductRepository productRepository;

    public SaleEntity execute(SaleDTO saleDTO) {
        ClientEntity clientEntity = toCheckClient(saleDTO.getClientID());
        Payment_MethodEntity paymentMethodEntity = toCheckPaymentMethod(saleDTO.getPaymentMethodID());
        SellerEntity sellerEntity = toCheckSeller(saleDTO.getSellerID());
        List<ProductEntity> produtos = toCheckProductExists(saleDTO.getList_products());


        SaleEntity saleEntity = saleDTO.toSaleEntity(clientEntity, paymentMethodEntity, sellerEntity, produtos);

        this.saleRepository
                .findById(saleEntity.getId())
                .ifPresent((sale) -> {
                    throw new SaleExceptions.SellerFoundException();
                });

        return this.saleRepository.save(saleEntity);
    }

    private ClientEntity toCheckClient(Integer idClient) {
        return this.clientRepository.findById(idClient)
                .orElseThrow(() -> new ClientExceptions.ClientNotFoundException());
    }

    private Payment_MethodEntity toCheckPaymentMethod(Integer idPaymentMethod) {
        return this.paymentMethodRepository.findById(idPaymentMethod)
                .orElseThrow(() -> new PaymentMethodExceptions.PaymentMethodNotFoundException());
    }

    private SellerEntity toCheckSeller(Integer idSeller) {
        return this.sellerRepository.findById(idSeller)
                .orElseThrow(() -> new SellerExceptions.SellerNotFoundException());
    }

    private List<ProductEntity> toCheckProductExists(List<Integer> list_products) {
        List<ProductEntity> produtos = productRepository.findAllById(list_products);

        if (produtos.size() != list_products.size()) {
            throw new ProductExceptions.TypeProductNotFoundException();
        }

        return produtos;
    }
}
