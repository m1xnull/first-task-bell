package com.bellintegrator.firstTask.organization;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Repository
public class OrganizationDaoImpl implements OrganizationDao {

    private final EntityManager em;

    public OrganizationDaoImpl(EntityManager entityManager) {
        this.em = entityManager;
    }

    @Override
    public List<Organization> filterBy(OrganizationDto organizationDto) {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Organization> organizationCriteria = cb.createQuery(Organization.class);
        Root<Organization> organizationRoot = organizationCriteria.from(Organization.class);

        List<Predicate> predicates = new ArrayList<>();


        if (!StringUtils.isEmpty(organizationDto.getName()))
            predicates.add(cb.equal(organizationRoot.get("name"), organizationDto.getName()));

        if (!StringUtils.isEmpty(organizationDto.getInn()))
            predicates.add(cb.equal(organizationRoot.get("inn"), organizationDto.getInn()));

        if (organizationDto.getActive() != null)
            predicates.add(cb.equal(organizationRoot.get("isActive"), organizationDto.getActive()));

        organizationCriteria.multiselect(organizationRoot.get("id"), organizationRoot.get("name"), organizationRoot.get("isActive"))
                .where(predicates.toArray(new Predicate[]{}));

        return em.createQuery(organizationCriteria).getResultList();
    }
}

