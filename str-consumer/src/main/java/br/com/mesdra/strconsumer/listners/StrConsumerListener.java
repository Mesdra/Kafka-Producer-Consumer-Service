package br.com.mesdra.strconsumer.listners;


import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {
    @KafkaListener(groupId = "group-1",topics = "str_topic",containerFactory = "strContainerFactory")
    public void listener(String messsage){
        log.info("Mensagem Recebida : {}",messsage);
    }


}
