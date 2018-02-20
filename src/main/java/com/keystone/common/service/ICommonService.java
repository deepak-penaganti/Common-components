/**
 * 
 */
package com.keystone.common.service;

import java.math.BigDecimal;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.keystone.common.dto.ICommonDTO;

import javassist.NotFoundException;

/**
 * @author nnarayanaperumaln
 *
 */
@Service
@Transactional
public interface ICommonService <T extends ICommonDTO>{

	/**
	 * @param dto
	 * @return
	 */
	T create(T dto);	
	
	/**
	 * @param dtoList
	 * @return
	 */
	List<T> create(List<T> dtoList);	
	
	/**
	 * @param dto
	 * @return
	 */
	T update(T dto);
	
	/**
	 * @param dto
	 */
	void delete(T dto);
	
	/**
	 * @param id
	 * @return
	 */
	T read(BigDecimal id);	
	
	/**
	 * @return
	 * @throws NotFoundException
	 */
	List<T> readAll() throws NotFoundException;
}