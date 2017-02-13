package portlets;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.util.ParamUtil;

import serviciopersonas.model.Persona;
import serviciopersonas.service.PersonaLocalServiceUtil;

import java.io.IOException;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.Portlet;
import javax.portlet.PortletException;

import org.osgi.service.component.annotations.Component;

@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=03_PersonaPortlet Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class PersonaPortlet extends MVCPortlet {
	
	public void addPersona(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		//Recogemos los parametros.
		String dni = ParamUtil.get(actionRequest, "dni", "");
		String nombre = ParamUtil.get(actionRequest, "nombre", "");
		String sEdad = ParamUtil.get(actionRequest, "edad", "");
		int iEdad = Integer.parseInt(sEdad);
		//Creamos la persona - Para ello importamos la clase persona del otro proyecto mediante Maven.
		//Para ello vamos a pom.xml
		
		//Una vez incorporadas las clases, podemos llamarlas mediante ...ServiceUtil.create...();
		Persona persona = PersonaLocalServiceUtil.createPersona(dni);
		//Esto sería equivalente a Persona persona = new Persona();
		persona.setNombre(nombre);
		persona.setEdad(iEdad);
		//No hace falta añadir el dni, porque ya se lo hemos pasado en la creación de la persona (objeto).
		
		//Despues persistimos o añadimos la persona a nuestra base de datos.
		PersonaLocalServiceUtil.addPersona(persona);
	}
	

	public void deletePersona(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String dni = ParamUtil.get(actionRequest, "dni", "");
		try {
			PersonaLocalServiceUtil.deletePersona(dni);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

	public void updatePersona(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String dni = ParamUtil.get(actionRequest, "dni", "");
		String nombre = ParamUtil.get(actionRequest, "nombre", "");
		String sEdad = ParamUtil.get(actionRequest, "edad", "");
		int iEdad = Integer.parseInt(sEdad);
		
		//Recuperamos la persona de la base de datos.
		try {
			Persona persona = PersonaLocalServiceUtil.getPersona(dni);
			persona.setNombre(nombre);
			persona.setEdad(iEdad);
			//Persistimos en base de datos.
			PersonaLocalServiceUtil.updatePersona(persona);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	

	public void getPersona(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String dni = ParamUtil.get(actionRequest, "dni", "");
		try {
			Persona persona = PersonaLocalServiceUtil.getPersona(dni);
		} catch (PortalException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	public void listarPersonas(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
			List<Persona> listaPersonas = PersonaLocalServiceUtil.getPersonas(-1, -1);
			//Al hacer que mande personas desde -1 a -1 trae todos los elementos contenidos en la tabla de la base de datos.
			actionRequest.setAttribute("listaPersonas", listaPersonas);
	}
	
	
	
	
	
	
	
}