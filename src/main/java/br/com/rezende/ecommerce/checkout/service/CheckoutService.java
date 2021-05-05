package br.com.rezende.ecommerce.checkout.service;

import br.com.rezende.ecommerce.checkout.resource.checkout.CheckoutRequest;
import br.com.rezende.ecommerce.checkout.entity.CheckoutEntity;

import java.util.Optional;

public interface CheckoutService {

    Optional<CheckoutEntity> create(CheckoutRequest checkoutRequest);

    Optional<CheckoutEntity> updateStatus(String checkoutCode, CheckoutEntity.Status status);
}
