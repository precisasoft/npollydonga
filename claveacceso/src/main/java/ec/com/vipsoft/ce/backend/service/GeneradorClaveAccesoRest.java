package ec.com.vipsoft.ce.backend.service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
@Stateless
@Path("/claveacceso")
public class GeneradorClaveAccesoRest {
	private SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd-hh-mm");

	@EJB
	private GeneradorClaveAcceso generador;
	
	
	@Path("/factura/{ruc}/{establecimiento}/{puntoemision}/{secuencia}")
	@Produces(MediaType.TEXT_PLAIN)
	@GET
	public String paraFacturaProduccion(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia){
		return generador.generarClaveAccesoFactura(new Date(),ruc, establecimiento, puntoEmision,false, secuencia, 1);
	}
	
	
	@Path("/factura/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String paraFactura(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas){
		return generador.generarClaveAccesoFactura(new Date(),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	@Path("/factura/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}/{fecha}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String paraFacturaFecha(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas,@PathParam("fecha")String patronFecha){		
		return generador.generarClaveAccesoFactura(obtenerFecha(patronFecha), ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);		
	}
	@Path("/nc/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}")
	@GET
	@Produces(MediaType.TEXT_PLAIN)	
	public String paranc(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas){
		return generador.generarClaveAccesoNotaCredito(new Date(),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	@Path("/nc/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}/{fecha}")
	@GET
	public String parancFecha(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas,@PathParam("fecha")String fecha){
		return generador.generarClaveAccesoNotaCredito(obtenerFecha(fecha),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
		
	@Path("/gr/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}")
	@GET
	public String paraguiaremision(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas){
		return generador.generarClaveAccesoGuiaRemision(new Date(),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	
	
	@Path("/gr/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}/{fecha}")
	@GET
	public String paraguiaremision(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas,@PathParam("fecha")String fecha){
		return generador.generarClaveAccesoGuiaRemision(obtenerFecha(fecha),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	
	@Path("/retencion/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}")
	@GET
	public String pararetencion(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas){
		return generador.generarClaveAccesoComprobanteRetencion(new Date(),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	@Path("/nd/{ruc}/{establecimiento}/{puntoemision}/{secuencia}/{enpruebas}")
	@GET
	public String parand(@NotNull @Pattern(regexp="[0-9]{13,13}")@PathParam("ruc")String ruc,@NotNull @Min(1) @Max(999) @PathParam("establecimiento")Integer establecimiento,@NotNull @Min(1) @Max(999) @PathParam("puntoemision")Integer puntoEmision,@NotNull @Min(1) @Max(999999999)@PathParam("secuencia")Long secuencia,@PathParam("enpruebas") boolean enPruebas){
		return generador.generarClaveAccesoNotaDebito(new Date(),ruc, establecimiento, puntoEmision, enPruebas, secuencia, 1);
	}
	
	private Date obtenerFecha(String patronRecibido){
		Date retorno=null;
		try {
			retorno=sdf.parse(patronRecibido);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return retorno;
	}
}
