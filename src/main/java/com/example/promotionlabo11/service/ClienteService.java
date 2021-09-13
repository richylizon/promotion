package com.example.promotionlabo11.service;

import com.example.promotionlabo11.model.Cliente;

import java.util.List;

public interface ClienteService {
    public List<Cliente> findAllCumpleaneros(String birthday);
}
