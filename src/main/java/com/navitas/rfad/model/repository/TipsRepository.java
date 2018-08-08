package com.navitas.rfad.model.repository;

import com.navitas.rfad.model.entity.Tips;

import java.util.UUID;

import org.springframework.data.repository.CrudRepository;

public interface TipsRepository extends CrudRepository<Tips, UUID> {

}
