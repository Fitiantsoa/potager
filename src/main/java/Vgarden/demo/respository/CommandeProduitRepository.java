package Vgarden.demo.respository;

import org.springframework.data.jpa.repository.JpaRepository;

import Vgarden.demo.model.CommandeProduit;
import Vgarden.demo.model.CommandeProduitKey;


public interface CommandeProduitRepository extends JpaRepository<CommandeProduit, CommandeProduitKey> {
}
