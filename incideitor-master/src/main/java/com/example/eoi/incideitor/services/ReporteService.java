package com.example.eoi.incideitor.services;


import com.example.eoi.incideitor.abstractcomponents.GenericServiceWithJPA;
import com.example.eoi.incideitor.dtos.ReporteDTO;
import com.example.eoi.incideitor.entities.Reporte;
import com.example.eoi.incideitor.mapper.ReporteMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ReporteService extends GenericServiceWithJPA<Reporte, Integer> {

    private final ReporteMapper reporteMapper;

    public ReporteService(ReporteMapper reporteMapper){this.reporteMapper = reporteMapper;}


    public ReporteDTO leerReporte (Integer id){
        ReporteDTO reporteDTO = new ReporteDTO();
        Optional<Reporte> reporte = this.repository.findById(id);
        if (reporte.isPresent()){
            reporteDTO = this.reporteMapper.toDto(reporte.get());
        }
        return reporteDTO;
    }

    public ReporteDTO guardarReporte (ReporteDTO dto){
        Reporte reporte = this.reporteMapper.toEntityReporte(dto);

    // Guardar Reporte
    Reporte reporteGuardado = update(reporte);
    return this.reporteMapper.toDto(reporteGuardado);
    }
}
