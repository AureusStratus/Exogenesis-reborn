package Exogenesis.type;

public enum DamageType{
    kinetic(0),
    energy(1),
    thermal(2),
    cryogenic(3),
    explosive(4),
    peirce(5);

    public final int index;

    //there is a better way to index this. I don't care.
    DamageType(int index){
        this.index = index;
    }
}