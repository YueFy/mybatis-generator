package com.test.generator.jpa;

import com.test.generator.entity.Hr;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

/**
 * @作者 usts4
 * @Github mingliantianxi
 * @时间 2020/7/27
 */
public interface HrJPA extends Serializable, JpaRepository<Hr,Integer>, JpaSpecificationExecutor<Hr> {
}
