/**
 * 
 */
package com.spring.nblFantasy.views.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.nblFantasy.Model.Classic;
import com.spring.nblFantasy.Service.ClassicService;
import com.spring.nblFantasy.views.resources.vo.ClassicVO;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * @author Owner
 *Cretaing the rest service for Classic
 */
@RestController
@RequestMapping("/api/classic")
@Api(tags="cliente")
public class ClassicResource {

	public final ClassicService classicService ;

	public ClassicResource(ClassicService classicService) {
		super();
		this.classicService = classicService;
	} 
	@PostMapping
	@ApiOperation(value="Creating Classic", notes ="Service to create a new classic")
	@ApiResponses(value = {@ApiResponse (code =201 , message ="Classic created successfully "), 
			@ApiResponse (code =400 , message= "Invalid Request")   })
	public ResponseEntity<Classic> createClassic (@RequestBody ClassicVO classicVo){
		Classic classic = new Classic();
		classic.setIdclassic(classicVo.getIdclassic());
		classic.setNumJornada(classicVo.getNumJornada());
		classic.setGolesJornada(classicVo.getGolesJornada());
	    classic.setAssistJornada(classicVo.getAssistJornada());
	    classic.setRedCardJornada(classicVo.getRedCardJornada());
	    classic.setCsheetJornada(classicVo.getCsheetJornada());
	    classic.setPtosJornada(classicVo.getPtosJornada());
	    classic.setBpsJornada(classicVo.getBpsJornada());
	    classic.setPtosenBanco(classicVo.getPtosenBanco());
	    classic.setPtosBBoost(classicVo.getPtosBBoost());
	    classic.setPtosWCard(classicVo.getPtosWCard());
	    classic.setPtosCapitan(classicVo.getPtosCapitan());
	    classic.setPtosViceCapitan(classicVo.getPtosViceCapitan());
	    classic.setRanking(classicVo.getRanking());
	    classic.setFormacion(classicVo.getFormacion());
	    classic.setCodigoLiga(classicVo.getCodigoLiga());
	   return new ResponseEntity<>(this.classicService.create(classic), HttpStatus.CREATED);
	
	}
	
	@PutMapping("/{identification}")
	@ApiOperation(value="Updating Classic", notes ="Service to update a new classic")
	@ApiResponses(value = {@ApiResponse (code =201 , message ="Classic updated successfully "), 
			@ApiResponse (code =404 , message= "Classic not Founded")   })
	public ResponseEntity<Classic> updateClassic (@PathVariable ("identification") int identification, ClassicVO classicVo){
		Classic classic = (Classic) this.classicService.findIdClassic(identification);
		if (classic == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		else {
		classic.setIdclassic(classicVo.getIdclassic());
		classic.setNumJornada(classicVo.getNumJornada());
		classic.setGolesJornada(classicVo.getGolesJornada());
	    classic.setAssistJornada(classicVo.getAssistJornada());
	    classic.setRedCardJornada(classicVo.getRedCardJornada());
	    classic.setCsheetJornada(classicVo.getCsheetJornada());
	    classic.setPtosJornada(classicVo.getPtosJornada());
	    classic.setBpsJornada(classicVo.getBpsJornada());
	    classic.setPtosenBanco(classicVo.getPtosenBanco());
	    classic.setPtosBBoost(classicVo.getPtosBBoost());
	    classic.setPtosWCard(classicVo.getPtosWCard());
	    classic.setPtosCapitan(classicVo.getPtosCapitan());
	    classic.setPtosViceCapitan(classicVo.getPtosViceCapitan());
	    classic.setRanking(classicVo.getRanking());
	    classic.setFormacion(classicVo.getFormacion());
	    classic.setCodigoLiga(classicVo.getCodigoLiga());
	    
	    
	   return new ResponseEntity<>(this.classicService.update(classic), HttpStatus.OK);
		}
	}
	//Usamos la anotacion deletemapping  para remover un elemento de la tabla 
	@DeleteMapping("/{identification}")
	@ApiOperation(value="Removing Classic", notes ="Service to remove a classic")
	@ApiResponses(value = {@ApiResponse (code =201 , message ="Classic removed successfully "), 
			@ApiResponse (code =404 , message= "Classic not Founded")   })
	public void removeClassic(@PathVariable ("identification") int identification) {
	 Classic classic = this.classicService.findIdClassic(identification);
	if (classic != null ) {
	     this.classicService.deleteIdClassic(classic);	
	}
	
	}
	
	@GetMapping
	@ApiOperation(value="List of Classic", notes ="Service to list all of classic")
	@ApiResponses(value = {@ApiResponse (code =201 , message ="List of Classic founded "), 
			@ApiResponse (code =404 , message= "List of classic not founded")   })
	public List<Classic> findAllClassic (){
		return this.classicService.findAllClassic();
		
	} 
		
}
