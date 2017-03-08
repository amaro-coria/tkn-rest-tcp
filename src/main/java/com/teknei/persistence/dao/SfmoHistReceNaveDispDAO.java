/**
 * Teknei 2016
 */
package com.teknei.persistence.dao;

import org.springframework.data.repository.CrudRepository;

import com.teknei.entities.SfmoHistReceNave;
import com.teknei.entities.SfmoHistReceNavePK;

/**
 * DAO Interface for SfmoHistReceNave
 * @author Jorge Amaro
 * @version 1.0.0
 * @since 1.0.0
 *
 */
public interface SfmoHistReceNaveDispDAO extends CrudRepository<SfmoHistReceNave, SfmoHistReceNavePK> {

}
