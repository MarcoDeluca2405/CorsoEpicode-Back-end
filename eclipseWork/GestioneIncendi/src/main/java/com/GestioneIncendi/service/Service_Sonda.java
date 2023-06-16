package com.GestioneIncendi.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.GestioneIncendi.model.Abstract_sonda;
import com.GestioneIncendi.model.Sonda;

import ch.qos.logback.core.recovery.ResilientSyslogOutputStream;

@Service
public class Service_Sonda {
	Logger log= LoggerFactory.getLogger(Service_Sonda.class);
	List<Sonda> listsonde=new ArrayList<>();
	List<Sonda> in_allarme=new ArrayList<>();
	
	public Optional<?> createSonda(Sonda sonda) {
		if(!listsonde.stream().anyMatch(s-> s.getId().equals(sonda.getId()))) {
			if(!listsonde.stream().anyMatch(s-> s.getAltidudine()==sonda.getAltidudine()&&s.getLongitudine()==sonda.getLongitudine())) {
		Sonda newSonda=new Sonda(sonda);
		listsonde.add(newSonda);
		if(newSonda.getLivello_fummo()>5) {
			in_allarme.add(newSonda);
			allarmePericolo();
		}
		
		return Optional.of(newSonda);
			}else {
				 log.warn("essite già con queste coordinate");
				 return Optional.of("essite già con queste coordinate");
			}
		}else {
		 log.warn("essite già con questo id");
		 return Optional.of("esiste già questo id");
		}
	}
	
	
	public void allarmePericolo() {
		if(!in_allarme.isEmpty()) {
		in_allarme.forEach(s-> log.error("Allarme in corso!! ->"+s));
		}
	}
	
	public Optional<?> allAlarmiAttivi() {
		if(!in_allarme.isEmpty()) {
			in_allarme.forEach(s-> log.error("Allarme in corso!! ->"+s));
			return Optional.of(in_allarme);
		}else {
			return Optional.of("Non ci sono allarmi attivi");
		}
	}
	
	public List<Sonda> getAllsonde() {
		listsonde.forEach(s-> log.info(s.toString()));
		return listsonde;
	}
	
	public String resetSonda(long id) {
		String message="";
		if(!listsonde.isEmpty()) {
		for(Sonda s : listsonde) {
			if(s.getId().equals(id)) {
				s.setLivello_fummo(0);
				

				if(in_allarme.stream().anyMatch(a-> a.getId().equals(s.getId()))) {
					message= "livello di fumo è stato ripristinato ->"+s;
					log.info("livello di fumo è stato ripristinato ->"+s);
					in_allarme.remove(s);
				}else {
					message= "livello di fumo è stato ripristinato ->"+s;
					log.info("livello di fumo è stato ripristinato ->"+s);
				}
				
			
			}else {
				message= "non esiste nessuna corrispodenza al numero di sonda";
			}
		}
		}else {
			message= "Non ci sono sonde al momento";
		}
		return message;
	}
	
	public String deleteSonda(long id) {
		String message="";
		if(!listsonde.isEmpty()) {
			for(Sonda s : listsonde) {
				if(s.getId().equals(id)) {
					listsonde.remove(s);
					return "la sonda è stata rimossa";
					
				}else {
					message= "non esiste nessuna corrispodenza al numero di sonda";
				}
			}
		}else {
			message= "Non ci sono sonde al momento";
		}
		return message;
	}
	
}
