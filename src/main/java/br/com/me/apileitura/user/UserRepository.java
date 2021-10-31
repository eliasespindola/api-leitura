package br.com.me.apileitura.user;

import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<User,Long> {
    User save(User user);
}
