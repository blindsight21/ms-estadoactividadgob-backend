/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.gob.mimp.estadoactividadgob.ws.rest;

import java.math.BigDecimal;
import java.util.List;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.gob.mimp.estadoactividadgob.bean.FindByParamBean;

import pe.gob.mimp.estadoactividadgob.bean.ResponseData;
import pe.gob.mimp.estadoactividadgob.bean.EstadoActividadGobBean;
import pe.gob.mimp.estadoactividadgob.service.EstadoActividadGobService;

/**
 *
 * @author BlindSight
 */
@RestController
@RequestMapping(value = "/")
public class EstadoActividadGobController {

    @Autowired
    private EstadoActividadGobService estadoActividadGobService;

    @PostMapping(value = "/crearEstadoActividadGob", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> crearEstadoActividadGob(@RequestBody EstadoActividadGobBean estadoActividadGobBean) throws Exception {

        estadoActividadGobService.crearEstadoActividadGob(estadoActividadGobBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.CREATED.value());
        response.setMsg(HttpStatus.CREATED.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/editarEstadoActividadGob", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> editarEstadoActividadGob(@RequestBody EstadoActividadGobBean estadoActividadGobBean) throws Exception {

        estadoActividadGobService.editarEstadoActividadGob(estadoActividadGobBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());

        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/obtenerEstadoActividadGobPorId/{nidEstadoActividadGob}")
    public ResponseEntity<ResponseData<?>> obtenerEstadoActividadGobPorId(@PathVariable("nidEstadoActividadGob") BigDecimal nidEstadoActividadGob) throws Exception {

        String txtEstadoActividadGob = estadoActividadGobService.obtenerEstadoActividadGobPorId(nidEstadoActividadGob);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(txtEstadoActividadGob);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/loadEstadoActividadGobList", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> loadEstadoActividadGobList(@RequestBody FindByParamBean findByParamBean) throws Exception {

        List<EstadoActividadGobBean> estadoActividadGobList = estadoActividadGobService.loadEstadoActividadGobList(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(estadoActividadGobList);

        return ResponseEntity.ok(response);

    }

    @PostMapping(value = "/getRecordCount", consumes = APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseData<?>> getRecordCount(@RequestBody FindByParamBean findByParamBean) throws Exception {

        Integer count = estadoActividadGobService.getRecordCount(findByParamBean);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(count);

        return ResponseEntity.ok(response);

    }
    
    @GetMapping(value = "/find/{id}")
    public ResponseEntity<ResponseData<?>> find(@PathVariable("id") BigDecimal id) throws Exception {

        EstadoActividadGobBean estadoActividadGobBean = estadoActividadGobService.find(id);

        ResponseData<Object> response = new ResponseData<>();
        response.setCod(HttpStatus.OK.value());
        response.setMsg(HttpStatus.OK.getReasonPhrase());
        response.setResultado(estadoActividadGobBean);

        return ResponseEntity.ok(response);

    }

}
