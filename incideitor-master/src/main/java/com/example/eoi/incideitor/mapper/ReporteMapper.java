package com.example.eoi.incideitor.mapper;

import com.example.eoi.incideitor.dtos.ReporteDTO;
import com.example.eoi.incideitor.entities.Reporte;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class ReporteMapper {
    /**
     * Convierte una entidad Reporte a un DTO ReporteDTO.
     *
     * @param entidad Entidad Reporte
     * @return DTO ReporteDTO
     */
    public ReporteDTO toDto(Reporte entidad){
        final ReporteDTO dto = new ReporteDTO();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(entidad, dto);
        return dto;
    }

    /**
     * Convierte un DTO ReporteDTO a una entidad Reporte.
     *
     * @param dto DTO ReporteDTO
     * @return Entidad Reporte
     */
    public Reporte toEntityReporte (ReporteDTO dto){
        final Reporte entity = new Reporte();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.map(dto, entity);
        return entity;
    }

    public ReporteMapper(){
    }
}
