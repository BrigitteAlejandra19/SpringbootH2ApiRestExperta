package com.example.springbooth2apirest.service;

import com.example.springbooth2apirest.entity.Bar;

import com.example.springbooth2apirest.exception.BarSearchException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.springbooth2apirest.repository.IBarRepo;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;

import static org.mockito.ArgumentMatchers.any;

import static org.mockito.Mockito.when;

class BarServiceImplTest {

    @Mock
    IBarRepo iBarRepoMock;

    @InjectMocks
    BarServiceImpl barService;

    private Bar bar;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        bar = new Bar();
        bar.setIdBar(1);
        bar.setNombre("Soy una prueba");
    }


    @Test
    void showAllCompleteInfo() throws BarSearchException {
    when(iBarRepoMock.findAll()).thenReturn(Arrays.asList(bar));
    Assertions.assertNotNull(barService.showAllCompleteInfo());
    }

    @Test
    void showAllPartialInfo() throws BarSearchException {
        when(iBarRepoMock.findAll()).thenReturn(Arrays.asList(bar));
        Assertions.assertNotNull(barService.showAllPartialInfo());
    }

}