package org.openpaas.paasta.marketplace.api.domain;

import lombok.Data;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Data
public class SoftwarePlanSpecification implements Specification<SoftwarePlan> {

    private static final long serialVersionUID = 1L;

    private String id;

    private Long softwareId;

    private String applyMonth;

    @Override
    public Predicate toPredicate(Root<SoftwarePlan> root, CriteriaQuery<?> query, CriteriaBuilder builder) {
        List<Predicate> restrictions = new ArrayList<>();
        if (id != null) {
            restrictions.add(builder.equal(root.get("id"), id));
        }
        if (softwareId != null) {
            restrictions.add(builder.equal(root.get("softwareId"), softwareId));
        }
        if (applyMonth != null) {
            restrictions.add(builder.equal(root.get("applyMonth"), applyMonth));
        }
        return builder.and(restrictions.toArray(new Predicate[] {}));

    }
}
