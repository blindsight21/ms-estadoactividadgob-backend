/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.estadoactividadgob.converter;

import pe.gob.mimp.estadoactividadgob.bean.EstadoActividadGobBean;
import pe.gob.mimp.siscap.model.EstadoActividadGob;

/**
 *
 * @author Omar
 */
public class EstadoActividadGobCast {

    public static EstadoActividadGobBean castEstadoActividadGobToEstadoActividadGobBean(EstadoActividadGob estadoActividadGob) {

        if (estadoActividadGob == null) {
            return null;
        }

        EstadoActividadGobBean estadoActividadGobBean = new EstadoActividadGobBean();

        estadoActividadGobBean.setNidEstadoActividadGob(estadoActividadGob.getNidEstadoActividadGob());
        estadoActividadGobBean.setTxtEstadoActividadGob(estadoActividadGob.getTxtEstadoActividadGob());
        estadoActividadGobBean.setFlgActivo(estadoActividadGob.getFlgActivo());
        estadoActividadGobBean.setNidUsuario(estadoActividadGob.getNidUsuario());
        estadoActividadGobBean.setTxtPc(estadoActividadGob.getTxtPc());
        estadoActividadGobBean.setTxtIp(estadoActividadGob.getTxtIp());
        estadoActividadGobBean.setFecEdicion(estadoActividadGob.getFecEdicion());

        return estadoActividadGobBean;
    }

    public static EstadoActividadGob castEstadoActividadGobBeanToEstadoActividadGob(EstadoActividadGobBean estadoActividadGobBean) {

        if (estadoActividadGobBean == null) {
            return null;
        }

        EstadoActividadGob estadoActividadGob = new EstadoActividadGob();

        estadoActividadGob.setNidEstadoActividadGob(estadoActividadGobBean.getNidEstadoActividadGob());
        estadoActividadGob.setTxtEstadoActividadGob(estadoActividadGobBean.getTxtEstadoActividadGob());
        estadoActividadGob.setFlgActivo(estadoActividadGobBean.getFlgActivo());
        estadoActividadGob.setNidUsuario(estadoActividadGobBean.getNidUsuario());
        estadoActividadGob.setTxtPc(estadoActividadGobBean.getTxtPc());
        estadoActividadGob.setTxtIp(estadoActividadGobBean.getTxtIp());
        estadoActividadGob.setFecEdicion(estadoActividadGobBean.getFecEdicion());

        return estadoActividadGob;
    }
}
