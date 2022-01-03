package Model;

import Entity.JoinTable;
import Entity.Relationship;
import Entity.Table;

public class UserAndAnimal {

    @JoinTable
    public User user;

    @Relationship(
            name = "User",
            joinColumns = "Id",
            inverseJoinColumns = "id"
    )
    public Animal animal;

    public UserAndAnimal() {
        this.animal = new Animal();
        this.user = new User();
    }

    public UserAndAnimal(User user, Animal animal) {
        this.user = user;
        this.animal = animal;
    }
}
