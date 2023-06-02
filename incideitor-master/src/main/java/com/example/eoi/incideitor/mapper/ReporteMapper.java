package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.ReporteDTO;
import com.example.eoi.incideitor.entities.Reporte;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReporteMapper {
    //Convertir de entidad a dto

    public ReporteDTO toDto(Reporte entidad){
        final ReporteDTO dto = new ReporteDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    public Reporte toEntityReporte (ReporteDTO dto){
        final Reporte entity = new Reporte();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
        return entity;
    }

    public ReporteMapper(){
    }
}
