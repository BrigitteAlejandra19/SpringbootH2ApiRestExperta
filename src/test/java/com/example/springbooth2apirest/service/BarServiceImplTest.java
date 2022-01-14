package com.example.springbooth2apirest.service;

import com.example.springbooth2apirest.entity.Bar;
import com.example.springbooth2apirest.exception.BarSearchException;
import com.example.springbooth2apirest.repository.IBarRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertNotNull;
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
    when(iBarRepoMock.findAll()).thenReturn(Collections.singletonList(bar));
    assertNotNull(barService.showAllCompleteInfo());
    }

    @Test
    void showAllPartialInfo() throws BarSearchException {
        when(iBarRepoMock.findAll()).thenReturn(Collections.singletonList(bar));
        assertNotNull(barService.showAllPartialInfo());
    }
}