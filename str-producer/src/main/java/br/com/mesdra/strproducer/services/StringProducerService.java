package br.com.mesdra.strproducer.services;


import br.com.mesdra.strproducer.exception.PublicException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@RequiredArgsConstructor
public class StringProducerService {

    private final KafkaTemplate<String,String> kafkaTemplate;

    public void sendMessage(String message) throws PublicException{
        kafkaTemplate.send("str_topic",message).addCallback(
                success -> log.info("Mensagem Enviada com Sucesso"),
                error -> {log.error("Erro ao enviar mensagem");
                    throw new PublicException("Erro ao enviar mensagem");
                });
    }

}
