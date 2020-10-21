/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.estadoactividadgob.service.impl;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.gob.mimp.siscap.model.EstadoActividadGob;
import pe.gob.mimp.siscap.repository.estadoactividadgob.EstadoActGobRepository;
import pe.gob.mimp.estadoactividadgob.bean.FindByParamBean;
import pe.gob.mimp.estadoactividadgob.bean.EstadoActividadGobBean;
import pe.gob.mimp.estadoactividadgob.converter.EstadoActividadGobCast;
import pe.gob.mimp.estadoactividadgob.util.Util;
import pe.gob.mimp.estadoactividadgob.service.EstadoActividadGobService;

/**
 *
 * @author Omar
 */
@Transactional(rollbackFor = Exception.class)
@Service
public class EstadoActividadGobServiceImpl implements EstadoActividadGobService {

    @Autowired
    private EstadoActGobRepository estadoActividadGobRepository;

    @Override
    public void crearEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) throws Exception {

        EstadoActividadGob estadoActividadGob = new EstadoActividadGob();
        estadoActividadGob.setTxtEstadoActividadGob(estadoActividadGobBean.getTxtEstadoActividadGob());
        estadoActividadGob.setNidUsuario(estadoActividadGobBean.getNidUsuario());
        estadoActividadGob.setTxtPc(estadoActividadGobBean.getTxtPc());
        estadoActividadGob.setTxtIp(estadoActividadGobBean.getTxtIp());
        estadoActividadGob.setFecEdicion(estadoActividadGobBean.getFecEdicion());
        estadoActividadGob.setFlgActivo(estadoActividadGobBean.getFlgActivo());

        estadoActividadGobRepository.save(estadoActividadGob);

    }

    @Override
    public void editarEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) {

        EstadoActividadGob estadoActividadGob = new EstadoActividadGob();

        estadoActividadGob.setNidEstadoActividadGob(estadoActividadGobBean.getNidEstadoActividadGob());
        estadoActividadGob.setTxtEstadoActividadGob(estadoActividadGobBean.getTxtEstadoActividadGob());
        estadoActividadGob.setNidUsuario(estadoActividadGobBean.getNidUsuario());
        estadoActividadGob.setTxtPc(estadoActividadGobBean.getTxtPc());
        estadoActividadGob.setTxtIp(estadoActividadGobBean.getTxtIp());
        estadoActividadGob.setFecEdicion(estadoActividadGobBean.getFecEdicion());
        estadoActividadGob.setFlgActivo(estadoActividadGobBean.getFlgActivo());

        estadoActividadGobRepository.save(estadoActividadGob);

    }

    @Override
    public String obtenerEstadoActividadGobPorId(BigDecimal nidEstadoActividadGob) throws Exception {

        Optional<EstadoActividadGob> estadoActividadGob = estadoActividadGobRepository.findById(nidEstadoActividadGob);

        if (estadoActividadGob.isPresent()) {
            return estadoActividadGob.get().getTxtEstadoActividadGob();
        }

        return "";
    }

    @Override
    public List<EstadoActividadGobBean> loadEstadoActividadGobList(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }

        List<EstadoActividadGob> estadoActividadGobList = estadoActividadGobRepository.findByParams(findByParamBean.getParameters(), findByParamBean.getOrderBy());

        if (!Util.esListaVacia(estadoActividadGobList)) {

            return estadoActividadGobList.stream().map(estadoActividadGob -> {
                EstadoActividadGobBean estadoActividadGobBean = new EstadoActividadGobBean();
                estadoActividadGobBean.setNidEstadoActividadGob(estadoActividadGob.getNidEstadoActividadGob());
                estadoActividadGobBean.setTxtEstadoActividadGob(estadoActividadGob.getTxtEstadoActividadGob());
                estadoActividadGobBean.setNidUsuario(estadoActividadGob.getNidUsuario());
                estadoActividadGobBean.setTxtPc(estadoActividadGob.getTxtPc());
                estadoActividadGobBean.setTxtIp(estadoActividadGob.getTxtIp());
                estadoActividadGobBean.setFecEdicion(estadoActividadGob.getFecEdicion());
                estadoActividadGobBean.setFlgActivo(estadoActividadGob.getFlgActivo());
                return estadoActividadGobBean;
            }).collect(Collectors.toList());
        }

        return null;
    }

    @Override
    public Integer getRecordCount(FindByParamBean findByParamBean) throws Exception {

        if (findByParamBean.getParameters() == null) {
            findByParamBean.setParameters(new HashMap<>());
        }
        Integer count = estadoActividadGobRepository.getRecordCount(findByParamBean.getParameters());
        return count;
    }

    @Override
    public EstadoActividadGobBean find(BigDecimal id) {

        Optional<EstadoActividadGob> estadoActividadGob = estadoActividadGobRepository.findById(id);

        if (!estadoActividadGob.isPresent()) {
            return null;
        }

        return EstadoActividadGobCast.castEstadoActividadGobToEstadoActividadGobBean(estadoActividadGob.get());

    }

}
