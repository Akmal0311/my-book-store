package uz.yt.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.yt.springdata.dao.Publisher;

import javax.persistence.criteria.CriteriaBuilder;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher, Integer> {
}
