package br.com.mesdra.strproducer.resources;


import br.com.mesdra.strproducer.exception.PublicException;
import br.com.mesdra.strproducer.services.StringProducerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/producer")
public class StringProducerController {

    private final StringProducerService producerService;

    @PostMapping
    public ResponseEntity<?> sendMessage(@RequestBody String message){
        message = message != null ? message.trim() : message;

        if(message != null  && !message.isEmpty()) {
            try {
                producerService.sendMessage(message);
                return ResponseEntity.status(HttpStatus.CREATED).build();
            }catch (PublicException e){
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e);
            }

        }else{
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }

    }


}
