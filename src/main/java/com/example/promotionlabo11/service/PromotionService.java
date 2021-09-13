package com.example.promotionlabo11.service;

import com.example.promotionlabo11.model.Cliente;
import com.example.promotionlabo11.model.Promotion;
import com.example.promotionlabo11.model.Type;

import java.util.List;

public interface PromotionService {
    public Promotion findPromotionByType(Type type);
    public Boolean sendPromoEmailsToBirthdayBoys(List<Cliente> birthdayBoys,Integer discountValue);
}
