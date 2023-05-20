package br.com.mesdra.strconsumer.listners;


import br.com.mesdra.strconsumer.custom.StrConsumerCurtomListener;
import lombok.extern.log4j.Log4j2;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class StrConsumerListener {
    @StrConsumerCurtomListener(groupId = "group-1")
    public void create(String messsage) {
        log.info("CREATE :: Mensagem Recebida : {}", messsage);
    }

    @StrConsumerCurtomListener(groupId = "group-1")
    public void log(String messsage) {
        log.info("LOG :: Mensagem Recebida : {}", messsage);
    }

    @KafkaListener(groupId = "group-2", topics = "str_topic", containerFactory = "strContainerFactory")
    public void history(String messsage) {
        log.info("HISTORY :: Mensagem Recebida : {}", messsage);
    }


}
