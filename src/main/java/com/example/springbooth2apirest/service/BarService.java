package com.example.springbooth2apirest.service;

import com.example.springbooth2apirest.entity.Bar;
import com.example.springbooth2apirest.entity.BarDto;
import com.example.springbooth2apirest.exception.*;

import java.util.List;

public interface BarService {
    void save(Bar bar) throws BarNotSaveException;

    List<Bar> showAllCompleteInfo() throws BarSearchException;

    List<BarDto> showAllPartialInfo() throws BarSearchException;

    void deleteByID(Integer idBar) throws BarNotFoundException, BarDeleteException;

    Bar showDetailsById(Integer id) throws BarNotFoundException;

    void init() throws BarInitException, BarSearchException;
}
