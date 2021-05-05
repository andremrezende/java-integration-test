package br.com.rezende.ecommerce.checkout.listener;

import br.com.rezende.ecommerce.checkout.streaming.PaymentPaidSink;
import br.com.rezende.ecommerce.checkout.entity.CheckoutEntity;
import br.com.rezende.ecommerce.checkout.service.CheckoutService;
import com.hatanaka.ecommerce.payment.event.PaymentCreatedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentPaidListener {

    private final CheckoutService checkoutService;

    @StreamListener(PaymentPaidSink.INPUT)
    public void handler(PaymentCreatedEvent paymentCreatedEvent) {
        checkoutService.updateStatus(paymentCreatedEvent.getCheckoutCode().toString(), CheckoutEntity.Status.APPROVED);
    }
}
