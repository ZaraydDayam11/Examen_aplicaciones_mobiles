
package pe.edu.upeu.asistencia.controllers;

import com.google.gson.Gson;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.upeu.asistencia.dtos.MaterialesDto;
import pe.edu.upeu.asistencia.models.Materiales;
import pe.edu.upeu.asistencia.services.MaterialesService;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/asis/materiales")
public class MaterialesController {

    @Autowired
    private MaterialesService materialesService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<List<Materiales>> listMateriales() {
        List<Materiales> actDto = materialesService.findAll();

        // Gson gson = new Gson();
        // String jsonCartList = gson.toJson(actDto);
        // System.out.println("Ver Aqui: "+jsonCartList);
        return ResponseEntity.ok(actDto);
        // return new ResponseEntity<>(actDto, HttpStatus.OK);
    }

    @PostMapping("/crear")
    public ResponseEntity<Materiales> createMateriales(@RequestBody MaterialesDto.MaterialesCrearDto materiales) {

        Materiales data = materialesService.save(materiales);
        return ResponseEntity.ok(data);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<Materiales> getMaterialesById(@PathVariable Long id) {
        Materiales materiales = materialesService.getMaterialesById(id);
        return ResponseEntity.ok(materiales);
    }

    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteMateriales(@PathVariable Long id) {
        Materiales materiales = materialesService.getMaterialesById(id);
        return ResponseEntity.ok(materialesService.delete(materiales.getId()));
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<Materiales> updateMateriales(@PathVariable Long id,
            @RequestBody MaterialesDto.MaterialesCrearDto materialesDetails) {
        Materiales updatedMateriales = materialesService.update(materialesDetails, id);
        return ResponseEntity.ok(updatedMateriales);
    }
}
