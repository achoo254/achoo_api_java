package com.achooapi.achoo_api_java.model.repository;

import com.achooapi.achoo_api_java.model.entity.Api;
import com.achooapi.achoo_api_java.model.entity.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter, String>, JpaSpecificationExecutor<Parameter> {
}
