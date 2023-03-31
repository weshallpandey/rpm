package com.crossasyst.rpm.entity;

import com.crossasyst.rpm.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "enterprise")
public class EnterpriseEntity extends BaseEntity {
    @Id
    @SequenceGenerator(name = "enterprise_seq_id", sequenceName = "enterprise_seq_id", initialValue = 1000, allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "enterprise_seq_id")
    @Column(name = "enterprise_id")
    private Long enterpriseId;
    @Column(name = "name")
    private String name;
}
