package com.example.promotionlabo11.service;

import com.example.promotionlabo11.model.Cliente;
import com.example.promotionlabo11.repository.ClienteRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepository clienteDao;

    public ClienteServiceImpl(ClienteRepository clienteDao) {
        this.clienteDao = clienteDao;
    }

    @Override
    public List<Cliente> findAllCumpleaneros(String birthday) {
        //Busqueda en bd
        List<Cliente> cumpleaneros = new ArrayList<Cliente>();
        Cliente cumpleanero1 = new Cliente(1L,"Richard","Vega","richylizon@gmail.com","09/21");
        Cliente cumpleanero2 = new Cliente(2L,"Romeo","Santos","santyromy@hotmail.com","09/21");
        cumpleaneros.add(cumpleanero1);
        cumpleaneros.add(cumpleanero2);
        return cumpleaneros;
    }
}
