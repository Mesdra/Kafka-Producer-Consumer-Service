package br.com.mesdra.paymentservice.service.impl;

import br.com.mesdra.paymentservice.model.Payment;
import br.com.mesdra.paymentservice.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Log4j2
@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {

    private final KafkaTemplate<String, Serializable> kafkaTemplate;

    @Override
    @SneakyThrows
    public void sendPayment(Payment payment) {
        log.info("Pagamento Recebido {}", payment);
        Thread.sleep(1000);
        log.info("Enviado Pagamento ...");
        kafkaTemplate.send("payment-topic",payment);
    }
}
