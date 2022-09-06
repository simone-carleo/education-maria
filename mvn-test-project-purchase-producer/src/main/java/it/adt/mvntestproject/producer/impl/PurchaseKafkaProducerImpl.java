package it.adt.mvntestproject.producer.impl;


import it.adt.mvntestproject.dto.PurchaseKafkaDto;
import it.adt.mvntestproject.producer.PurchaseKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

@Service
public class PurchaseKafkaProducerImpl implements PurchaseKafkaProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(PurchaseKafkaProducerImpl.class);

    @Autowired
    public KafkaTemplate<String, PurchaseKafkaDto> kafkaProducerTemplate;


    @Value("${education-maria.kafka.topic.publish-message.output}")
    String kafkaTopic;

    public void sendMessage(PurchaseKafkaDto data) {
        ListenableFuture<SendResult<String, PurchaseKafkaDto>> future = kafkaProducerTemplate.send(kafkaTopic, data);

        future.addCallback(new ListenableFutureCallback<SendResult<String, PurchaseKafkaDto>>() {

            @Override
            public void onSuccess(SendResult<String, PurchaseKafkaDto> result) {
                LOGGER.info("Sent message=[" + data + "] on topic=[" + kafkaTopic + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }

            @Override
            public void onFailure(Throwable ex) {
                LOGGER.error("Unable to send message=[" + data + "] on topic=[" + kafkaTopic + "] due to : " + ex.getMessage());
            }
        });

    }

}
