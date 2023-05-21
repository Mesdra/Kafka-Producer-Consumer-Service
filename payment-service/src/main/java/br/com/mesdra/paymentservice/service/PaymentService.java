package br.com.mesdra.paymentservice.service;

import br.com.mesdra.paymentservice.model.Payment;

public interface PaymentService {

    void sendPayment(Payment payment);
}
