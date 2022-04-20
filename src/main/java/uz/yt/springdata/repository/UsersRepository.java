package uz.yt.springdata.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.yt.springdata.dao.Users;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer>{
}
