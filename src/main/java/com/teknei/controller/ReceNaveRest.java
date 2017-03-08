/**
 * Teknei 2016
 */
package com.teknei.controller;

import java.sql.Timestamp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.teknei.entities.SfmoHistReceNave;
import com.teknei.entities.SfmoHistReceNavePK;
import com.teknei.persistence.dao.SfmoHistReceNaveDispDAO;

/**
 * Rest controller for recenave saving
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
@RestController
@RequestMapping("recenave")
public class ReceNaveRest {

	/*
	 * Injected value
	 * */
	@Autowired
	private SfmoHistReceNaveDispDAO daoReceNave;
	private static final Logger log = LoggerFactory.getLogger(ReceNaveRest.class);

	/**
	 * Rest save method
	 * @param idVehi - the id of the vehicle
	 * @param idRecoNave - the id of the record
	 * @param lat - the latitude
	 * @param lot - the longitude
	 * @param epoch - the unix date
	 * @return
	 */
	@RequestMapping(value = "save/{idVehi}/{idRecoNave}/{lat}/{lot}/{epoch}", method = RequestMethod.GET)
	public int saveReceNave(@PathVariable Integer idVehi, @PathVariable Long idRecoNave, @PathVariable Double lat,
			@PathVariable Double lot, @PathVariable Long epoch) {
		try {
			saveReceNaveLocal(idVehi, idRecoNave, lat, lot, epoch);
			return 0;
		} catch (Exception e) {
			log.error("Error in saveReceNave: {}", e.getMessage());
			return 1;
		}
	}

	/**
	 * Method that performs the db saving
	 * @param idVehi
	 * @param idRecoNave
	 * @param lat
	 * @param lont
	 * @param epoch
	 */
	private void saveReceNaveLocal(Integer idVehi, Long idRecoNave, Double lat, Double lont, Long epoch) {
		SfmoHistReceNavePK pk = new SfmoHistReceNavePK();
		pk.setIdRecoNave(idRecoNave.intValue());
		pk.setIdVehi(idVehi);
		SfmoHistReceNave hist = new SfmoHistReceNave();
		hist.setPk(pk);
		hist.setDistRecoReceNave(null);
		hist.setFchCrea(new Timestamp(System.currentTimeMillis()));
		hist.setFchModi(null);
		hist.setFchReceNave(new Timestamp(epoch * 1000));
		hist.setHoraGpsReceNave(null);
		hist.setHoraSistReceNave(null);
		hist.setIdConSis(1);
		hist.setIdEsta(1);
		hist.setIdTipo(3);
		hist.setLatiReceNave(lat);
		hist.setLongReceNave(lont);
		hist.setModeReceNave(null);
		hist.setNumSeriRecoNave(null);
		hist.setTimeRecoReceNave(null);
		hist.setUsrCrea("tcp-server");
		hist.setUsrModi(null);
		hist.setVeloReceNave(null);
		daoReceNave.save(hist);
	}

}
