package com.crossasyst.rpm.service;

import com.crossasyst.rpm.entity.EnterpriseEntity;
import com.crossasyst.rpm.mapper.EnterpriseMapper;
import com.crossasyst.rpm.model.Enterprise;
import com.crossasyst.rpm.repository.EnterpriseRepository;
import com.crossasyst.rpm.response.EnterpriseResponse;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@Log4j2
public class EnterpriseService {

    private final EnterpriseMapper enterpriseMapper;
    private final EnterpriseRepository enterpriseRepository;

    @Autowired
    public EnterpriseService(EnterpriseMapper enterpriseMapper, EnterpriseRepository enterpriseRepository) {
        this.enterpriseMapper = enterpriseMapper;
        this.enterpriseRepository = enterpriseRepository;
    }

    public EnterpriseResponse createEnterprise(Enterprise enterprise) {

        log.info("Adding Enterprise.");
        EnterpriseEntity enterpriseEntity = enterpriseMapper.modelToEntity(enterprise);
        enterpriseRepository.save(enterpriseEntity);
        log.info("Enterprise details saved successfully.");
        EnterpriseResponse enterpriseResponse = new EnterpriseResponse();
        enterpriseResponse.setEnterpriseId(enterpriseEntity.getEnterpriseId());
        log.info("Activity id {} ", enterpriseEntity.getEnterpriseId());
        return enterpriseResponse;
    }

    public List<Enterprise> findAllEnterprises() {
        log.info("Fetching all Enterprises.");
        List<EnterpriseEntity> enterpriseEntities = enterpriseRepository.findAll();
        List<Enterprise> getAllEnterprsies = enterpriseMapper.entityToModel(enterpriseEntities);
        return getAllEnterprsies;
    }

    public Enterprise findEnterprise(Long enterpriseId) {
        log.info("fetching enterprise.");
        Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);
        Enterprise getEnterprise = new Enterprise();
        if (enterpriseEntity.isPresent()) {
            getEnterprise = enterpriseMapper.entityToModel(enterpriseEntity.get());
            log.info("Enterprise got successfully.");
        }
        return getEnterprise;

    }

    public void updateEnterprise(Long enterpriseId, Enterprise enterprise) {
        log.info("fetching enterprise");
        Optional<EnterpriseEntity> enterpriseEntity = enterpriseRepository.findById(enterpriseId);

        if (enterpriseEntity.isPresent()) {
            EnterpriseEntity enterpriseEntity1 = enterpriseMapper.modelToEntity(enterprise);
            enterpriseEntity1.setEnterpriseId(enterpriseEntity.get().getEnterpriseId());
            enterpriseRepository.save(enterpriseEntity1);
            log.info("Enterprise updated successfully.");
        }
    }
}

