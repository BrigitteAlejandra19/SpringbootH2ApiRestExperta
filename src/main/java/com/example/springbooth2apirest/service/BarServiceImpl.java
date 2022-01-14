package com.example.springbooth2apirest.service;

import com.example.springbooth2apirest.entity.Bar;
import com.example.springbooth2apirest.entity.BarDto;
import com.example.springbooth2apirest.exception.*;
import com.example.springbooth2apirest.repository.IBarRepo;
import com.example.springbooth2apirest.utils.BarInitUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class BarServiceImpl implements BarService {

    private final IBarRepo iBarRepo;

    @Autowired
    public BarServiceImpl(IBarRepo iBarRepo) { this.iBarRepo = iBarRepo; }

    @Override
    public void save(Bar bar) throws BarNotSaveException {
        try {
            iBarRepo.save(bar);
        } catch (Exception e) {
            throw new BarNotSaveException();
        }
   }

    @Override
    public List<Bar> showAllCompleteInfo() throws BarSearchException {
        try{
            List<Bar> bars = new ArrayList<>();
            for(Bar bar : iBarRepo.findAll()) {
                bars.add(  new Bar(
                        bar.getIdBar(),
                        bar.getNombre(),
                        bar.getDomicilio(),
                        bar.getPuntuacion(),
                        bar.getEmail(),
                        bar.getTelefono(),
                        bar.getCuit(),
                        bar.getHorario(),
                        bar.getEstacionamiento())
                );
            }
            return bars;
        } catch (Exception e) {
            throw new BarSearchException();
        }
    }

    @Override
    public List<BarDto> showAllPartialInfo() throws BarSearchException {
        try{
            List<BarDto> barDtos = new ArrayList<>();
            for(Bar bar : iBarRepo.findAll()) {
            barDtos.add(  new BarDto(bar.getIdBar(), bar.getNombre(), bar.getDomicilio(), bar.getPuntuacion()));
            }
            return barDtos;
        } catch (Exception e) {
            throw new BarSearchException();
            }
    }

    @Override
    public void deleteByID(Integer idBar) throws BarNotFoundException, BarDeleteException {
        if(!iBarRepo.existsById(idBar)) {
            throw new BarNotFoundException();
        }
        try{
            iBarRepo.deleteById(idBar);
        } catch (Exception e) {
            throw new BarDeleteException();
        }
    }

    @Override
    public Bar showDetailsById(Integer id) throws BarNotFoundException {
        final Optional<Bar> barOpt = iBarRepo.findById(id);
        if(barOpt.isPresent()) {
            return barOpt.get();
        }
        throw new BarNotFoundException();
    }

    @Override
    public void init() throws BarInitException, BarSearchException {
        if(showAllCompleteInfo().isEmpty()) {
            try {
                List<Bar> bars = BarInitUtils.createBarsInit();
                if(iBarRepo.saveAll(bars).isEmpty()) {
                    throw new BarInitException();
                }
            } catch (Exception e) {
                throw new BarInitException();
            }
        }
    }
}
