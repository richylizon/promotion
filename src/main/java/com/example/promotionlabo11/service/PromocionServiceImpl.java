package com.example.promotionlabo11.service;

import com.example.promotionlabo11.model.Cliente;
import com.example.promotionlabo11.model.Promotion;
import com.example.promotionlabo11.model.Type;
import com.example.promotionlabo11.repository.PromotionRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PromocionServiceImpl implements PromotionService {

    @Value("${spring.mail.username}")
    private String sender;
    private final PromotionRepository promotionDao;
    private final JavaMailSender javaMailSender;

    public PromocionServiceImpl(PromotionRepository promotionDao, JavaMailSender javaMailSender) {
        this.promotionDao = promotionDao;
        this.javaMailSender = javaMailSender;
    }


    @Override
    public Promotion findPromotionByType(Type type) {
        Promotion result = new Promotion(1L,Type.CUMPLEANOS,"<name> Hoy es su cumpleaños que seas muy feliz te tenemos un descuento <discountValue> % de descuento. Valido por 24 hrs");
        return result;
    }

    @Override
    public Boolean sendPromoEmailsToBirthdayBoys(List<Cliente> birthdayBoys, Integer discountValue){

        Promotion promotion = findPromotionByType(Type.CUMPLEANOS);

        for (Cliente cli : birthdayBoys) {
            String fixedMessageName = promotion.getDescription().replace("<name>",cli.getFirstName());
            String fixedMessageDiscount = fixedMessageName.replace("<discountValue>",discountValue.toString());

            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(sender);
            message.setTo(cli.getEmail());
            message.setSubject(promotion.getType().toString());
            message.setText(fixedMessageDiscount);
            javaMailSender.send(message);
        }
        return true;
    }
}
