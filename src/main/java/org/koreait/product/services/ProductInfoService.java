package org.koreait.product.services;

import org.koreait.admin.product.controllers.RequestProduct;
import org.koreait.product.entities.Product;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Lazy
@Service
public class ProductInfoService {

    public Product get (Long seq){
        return null;

    }
    public RequestProduct getForm(Long seq){
        return  null;
    }

}
