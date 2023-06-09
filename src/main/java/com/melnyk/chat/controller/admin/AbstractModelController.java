package com.melnyk.chat.controller.admin;

import com.melnyk.chat.service.AbstractModelService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

public abstract class AbstractModelController<T, ID> {

//    @Getter
//    private AbstractModelService<T, ID> modelService;

    public abstract AbstractModelService<T, ID> getModelService();

//    protected AbstractModelController(AbstractModelService<T, ID> modelService) {
//        this.modelService = modelService;
//    }

    @RequestMapping(
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public List<T> readList(@RequestParam(value = "ids",required = false) List<ID> ids, HttpServletRequest request, @RequestHeader Map<String, String> header) {
        return getModelService().findAllById(ids);
    }

    @RequestMapping(
            value = {"/{id}"},
            method = {RequestMethod.GET}
    )
    @ResponseBody
    public ResponseEntity<T> read(@PathVariable ID id, HttpServletRequest request, @RequestHeader Map<String, String> header) {
        return ResponseEntity.ok(getModelService().findById(id).orElse(null));
    }

    @RequestMapping(
            method = {RequestMethod.POST}
    )
    @ResponseBody
    public ResponseEntity<T> save(@RequestBody T dto, HttpServletRequest request, @RequestHeader Map<String, String> header) {
        return ResponseEntity.ok(getModelService().save(dto));
    }

}
