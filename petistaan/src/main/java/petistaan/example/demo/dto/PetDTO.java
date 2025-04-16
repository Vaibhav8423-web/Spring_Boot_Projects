package petistaan.example.demo.dto;

import petistaan.example.demo.enums.Gender;
import petistaan.example.demo.enums.PetType;

import javax.persistence.*;
import java.util.Objects;
@Entity
public class PetDTO {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private PetType type;
    @OneToOne
    @JoinColumn(name = "owner_id")
    private OwnerDTO ownerDTO;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public PetType getType() {
        return type;
    }

    public void setType(PetType petType) {
        this.type = petType;
    }

    public OwnerDTO getOwnerDTO() {
        return ownerDTO;
    }

    public void setOwnerDTO(OwnerDTO ownerDTO) {
        this.ownerDTO = ownerDTO;
    }

    @Override
    public String toString() {
        return "PetDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", type=" + type +
                ", ownerDTO=" + ownerDTO +
                '}';
    }
}
