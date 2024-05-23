package com.pccomponentes.practice.service.basket;

import com.pccomponentes.practice.dto.BasketProductDTO;
import com.pccomponentes.practice.entity.Basket;
import com.pccomponentes.practice.entity.BasketProduct;
import com.pccomponentes.practice.entity.Product;
import com.pccomponentes.practice.entity.ProductSale;
import com.pccomponentes.practice.exception.APIException;
import com.pccomponentes.practice.exception.APIRequestException;
import com.pccomponentes.practice.mapper.BasketProductMapper;
import com.pccomponentes.practice.repository.BasketProductRepo;
import com.pccomponentes.practice.repository.BasketRepo;
import com.pccomponentes.practice.repository.ProductRepo;
import com.pccomponentes.practice.repository.ProductSaleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BasketService implements iBasketService {

    @Autowired
    BasketRepo basketRepo;
    @Autowired
    ProductSaleRepo productSaleRepo;
    @Autowired
    BasketProductRepo basketProductRepo;

    @Override
    public List<BasketProductDTO> findAllProductOfBasket(Long id_basket) {
        return BasketProductMapper.mapToBasketProductDTOList(basketProductRepo.findByBasketID(id_basket));
    }

    @Override
    public Boolean updateProductOfBasket(Long id_basket, Long id_product, Integer quantity) {

        Optional<Basket> basket = basketRepo.findById(id_basket);
        if(basket.isEmpty()) return false;
        Optional<ProductSale> productSale = productSaleRepo.findById(id_product);
        if(productSale.isEmpty()) return false;

        if(productSale.get().getStock() < quantity) throw new APIException(APIRequestException.OUT_OF_STOCK);

        productSale.get().setStock(productSale.get().getStock() - quantity);
        productSale.get().setSold(productSale.get().getSold() + quantity);
        productSaleRepo.save(productSale.get());

        BasketProduct basketProductSelected = basketProductRepo.findByBasketIDAndProductID(id_basket, id_product);
        if(basketProductSelected == null) {
            BasketProduct newBasketProduct = new BasketProduct();
            newBasketProduct.setBasket(basket.get());
            newBasketProduct.setProduct(productSale.get().getProduct());
            newBasketProduct.setQuantity(quantity);
            basketProductRepo.save(newBasketProduct);
        } else {
            basketProductSelected.setQuantity(basketProductSelected.getQuantity() + quantity);
            if(basketProductSelected.getQuantity() == 0) {
                basketProductRepo.delete(basketProductSelected);
            } else {
                basketProductRepo.save(basketProductSelected);
            }
        }
        return true;
    }

    @Override
    public Boolean deleteProductOfBasket(Long id_basketProduct) {
        basketProductRepo.deleteById(id_basketProduct);
        return true;
    }
}