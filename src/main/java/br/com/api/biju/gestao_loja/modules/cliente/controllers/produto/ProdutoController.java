package br.com.api.biju.gestao_loja.modules.cliente.controllers.produto;

import br.com.api.biju.gestao_loja.modules.cliente.models.produto.ProdutoEntity;
import br.com.api.biju.gestao_loja.modules.cliente.useCases.produto.CreateProdutoUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/produto")
public class ProdutoController {

    @Autowired
    CreateProdutoUseCase createProdutoUseCase;

    @PostMapping("/create")
    public ResponseEntity<Object> createProduct(@RequestBody ProdutoEntity produtoEntity) {
        try {
            var response = this.createProdutoUseCase.execute(produtoEntity);
            return ResponseEntity.ok().body(response);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
