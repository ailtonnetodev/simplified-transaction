package com.simplifiedtransaction.services;

import com.simplifiedtransaction.domain.user.User;
import com.simplifiedtransaction.dtos.NotificationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class NotificationService {

    @Autowired
    private RestTemplate restTemplate;

    public void sendNotification(User user, String message) throws Exception {
        String email = user.getEmail();
        NotificationDTO notificationRequest = new NotificationDTO(email, message);

        System.out.println("Notificaco enviada para o usuario");

//        ResponseEntity<String> notificationResponse = restTemplate.postForEntity("https://util.devi.tools/api/v1/notify", notificationRequest, String.class);
//
//        if(!(notificationResponse.getStatusCode() == HttpStatus.OK)){
//            System.out.println("Erro ao Enviar a Notificação.");
//            throw new Exception("Servico de Notificação está fora do ar.");
//        }
    }
}
