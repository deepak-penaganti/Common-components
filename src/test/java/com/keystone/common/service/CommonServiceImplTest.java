package com.keystone.common.service;

import static org.mockito.Mockito.when;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.data.jpa.repository.JpaRepository;

import com.keystone.common.dto.ICommonDTO;
import com.keystone.common.mapper.IBaseMapper;
import com.keystone.common.service.impl.CommonServiceImpl;

import javassist.NotFoundException;


@RunWith(MockitoJUnitRunner.class)
public class CommonServiceImplTest {
	
	class TestCommonServiceImpl extends CommonServiceImpl<SampleDTO, SampleEntity>{
		
		JpaRepository<SampleEntity, Long> repo;
		IBaseMapper<SampleDTO, SampleEntity> mapper = new BaseMapper();
		

		@Override
		public JpaRepository<SampleEntity, Long> getJPARepository() {
			return repo;
		}

		@Override
		public IBaseMapper<SampleDTO, SampleEntity> getMapper() {
			return mapper;
		}
	}
	class BaseMapper implements IBaseMapper<SampleDTO, SampleEntity>{

		@Override
		public SampleDTO convertToDTO(SampleEntity entity) {
			return new SampleDTO();
		}

		@Override
		public List<SampleDTO> convertToDTOList(List<SampleEntity> entities) {
			List<SampleDTO> dtos = new ArrayList<>();
			dtos.add(new SampleDTO());
			return dtos;
		}

		@Override
		public SampleEntity convertToEntity(SampleDTO dto) {
			return new SampleEntity();
		}

		@Override
		public List<SampleEntity> convertToEntityList(List<SampleDTO> dto) {
			List<SampleEntity> entities = new ArrayList<>();
			entities.add(new SampleEntity());
			return entities;
		}

		
	}
	class SampleDTO implements ICommonDTO{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	}
	
	class SampleEntity implements Serializable{

		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private int id;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		
	}
	
	
	@Mock
	JpaRepository<SampleEntity, Long> repo;
	
	@Mock
	IBaseMapper<SampleDTO, SampleEntity> mapper;
	
	TestCommonServiceImpl service = new TestCommonServiceImpl();
	
	@Before
	public void init() {
		service.mapper = mapper;
		service.repo = repo;
	}
	
	@Test
	public void testCreate() {
		SampleDTO dto = new SampleDTO();
		SampleEntity entity = new SampleEntity();
		entity.setId(10);
		dto.setId(10);
		when(mapper.convertToEntity(dto)).thenReturn(entity);
		when(repo.saveAndFlush(entity)).thenReturn(entity);
		when(mapper.convertToDTO(entity)).thenReturn(dto);
		SampleDTO result = service.create(dto);
		Assert.assertEquals(result, dto);
	}
	
	@Test
	public void testCreateList() {
		
		List<SampleDTO> dtoList = new ArrayList<>();
		List<SampleEntity> entities = new ArrayList<>();
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		dtoList.add(dto);
		when(mapper.convertToEntityList(dtoList)).thenReturn(entities);
		when(repo.save(entities)).thenReturn(entities);
		when(mapper.convertToDTOList(entities)).thenReturn(dtoList);
		List<SampleDTO> result = service.create(dtoList);
		Assert.assertEquals(result.get(0),dto);
	}
	
	@Test
	public void testUpdate() {
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		SampleDTO result = service.update(dto);
		Assert.assertEquals(result, dto);
	}
	
	@Test
	public void testDelete() {
		service.delete(new SampleDTO());		
	}
	
	@Test
	public void testRead() {
		BigDecimal id = new BigDecimal(10);
		SampleDTO dto = service.read(id);
		Assert.assertNull(dto);
	}

	@Test
	public void testReadAll() throws NotFoundException {
		
		List<SampleDTO> dtoList = new ArrayList<>();
		List<SampleEntity> entities = new ArrayList<>();
		entities.add(new SampleEntity());
		SampleDTO dto = new SampleDTO();
		dto.setId(10);
		dtoList.add(dto);
		when(repo.findAll()).thenReturn(entities);
		when(mapper.convertToDTOList(entities)).thenReturn(dtoList);
		List<SampleDTO> resultList = service.readAll();
		Assert.assertEquals(resultList.get(0), dto);
	}
	
	@Test(expected = NotFoundException.class)
	public void testReadAllException() throws NotFoundException {
		List<SampleDTO> dtoList = new ArrayList<>();
		when(repo.findAll()).thenReturn(null);
		service.readAll();
	}
}
