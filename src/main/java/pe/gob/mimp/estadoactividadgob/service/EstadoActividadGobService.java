/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.estadoactividadgob.service;

import java.math.BigDecimal;
import java.util.List;
import pe.gob.mimp.estadoactividadgob.bean.FindByParamBean;
import pe.gob.mimp.estadoactividadgob.bean.EstadoActividadGobBean;

/**
 *
 * @author Omar
 */
public interface EstadoActividadGobService {

    void crearEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) throws Exception;

    void editarEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) throws Exception;

//    void anularEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) throws Exception;
    String obtenerEstadoActividadGobPorId(BigDecimal nidEstadoActividadGob) throws Exception;

    List<EstadoActividadGobBean> loadEstadoActividadGobList(FindByParamBean findByParamBean) throws Exception;

    Integer getRecordCount(FindByParamBean findByParamBean) throws Exception;

    EstadoActividadGobBean find(BigDecimal id);
}
